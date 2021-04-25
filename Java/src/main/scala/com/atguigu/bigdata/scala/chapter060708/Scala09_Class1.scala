package com.atguigu.bigdata.scala.chapter060708

import java.util.Date

import scala.beans.BeanProperty

// 面向对象 - 类
object Scala09_Class1 {
    def main(args: Array[String]): Unit = {

        val user:User09 = new ChildUser09
        println(user.name)

    }
}
class User09 {

    val name : String = "zhangsan"

    def test(): Unit = {
        //println("user09...")
        //name = "zhaoliu"
        //println(name)
    }
}

class ChildUser09 extends User09 {
    // 子类可以重写父类val声明的完整变量，增加override修饰符
    override val name : String = "lisi"

    // 子类如果想要重写父类的完整方法，那么必须要使用override修饰符
    override def test(): Unit = {
        println("xxxxx")
    }
}

