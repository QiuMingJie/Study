package com.atguigu.bigdata.scala.chapter060708

import java.util.Date

import scala.beans.BeanProperty

// 面向对象 - 类
object Scala10_Class2 {
    def main(args: Array[String]): Unit = {

        val user = new ChildUser10()
    }
}
class User10(s:String) {
    println("parent = " + s)

    def this ( s : String, i : Int ) {
        this(s)
        println("parent1 = " + s)
    }
}

// 显示调用父类的构造方法 : 继承父类时，在父类后声明参数列表
// 如果子类构造方法有参数，那么可以将参数直接传递到父类构造方法中
class ChildUser10(s:String) extends User10(s, 20) {

    println("child ....")

    def this() {
        this("hhhhh")
        println("child1....")
    }
}

