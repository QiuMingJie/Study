package com.atguigu.bigdata.scala.chapter16

object Scala02_Class2 {

    def main(args: Array[String]): Unit = {

        test(new Child2())
    }

    // 泛型的上限
    //def test[T <: User2](t:T): Unit = {
    // 泛型的下限, 什么对象都可以方法
    def test[T >: User2](t:T): Unit = {
        println(t)
    }
}
class Person2 {

}
class User2 extends Person2 {

}
class Child2 extends User2 {

}

