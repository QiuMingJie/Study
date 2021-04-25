package com.atguigu.bigdata.scala.chapter12

object Scala05_Match5 {

    def main(args: Array[String]): Unit = {


        // Scala中的模式匹配可以匹配对象（样例类对象）
        for (amt <- Array(Dollar(1000.0), Currency(1000.0, "RMB"), NoAmount)) {
            val result = amt match {
                case Dollar(v) => "$" + v
                case Jp(v) => "Y" + v
                case Currency(v, u) => v + " " + u

                case NoAmount => ""
            }
            println(amt + ": " + result)
        }


        val dollar = Dollar(1000)
        // 样例类中构造方法的参数默认为val修饰的变量，如果需要更改，那么必须采用var声明
        dollar.value = 20.0

        val dollar1: Dollar = dollar.copy()

        println(dollar1.value)


    }
}
abstract sealed class Amount
case class Dollar(var value: Double) extends Amount {

}
case class Currency(value: Double, unit: String) extends Amount
case object NoAmount extends Amount
case class Jp(var value: Double) extends Amount {

}