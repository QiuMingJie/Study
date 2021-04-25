package com.atguigu.bigdata.scala.chapter05

object Scala09_Function5 {

    def main(args: Array[String]): Unit = {

        //lazy val res = sum(10, 20)
        val res = sum(10, 20)
        println("-----------------")
        println("res=" + res)

    }

    def sum(n1 : Int, n2 : Int): Int = {
        println("sum() 执行了..")
        return  n1 + n2
    }

}
