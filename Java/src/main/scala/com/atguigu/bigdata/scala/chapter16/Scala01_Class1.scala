package com.atguigu.bigdata.scala.chapter16

object Scala01_Class1 {

    def main(args: Array[String]): Unit = {

        // 泛型
        // Scala泛型声明方式为中括号[类型]

        // 默认情况下，scala中的泛型和java是一致的，但是进行扩展，协变（+），逆变（-）
        //val test : Test[User1] = new Test[Person1]()
        val test : Test[User1] = new Test[Child1]()

        println(test)

    }
}
class Person1 {

}
class User1 extends Person1 {

}
class Child1 extends User1 {

}
class Test[+User1] {

}
