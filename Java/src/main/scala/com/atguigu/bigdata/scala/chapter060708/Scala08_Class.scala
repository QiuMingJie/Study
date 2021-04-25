package com.atguigu.bigdata.scala.chapter060708

import java.util.Date

import scala.beans.BeanProperty

// 面向对象 - 类
object Scala08_Class {
    def main(args: Array[String]): Unit = {


        // scala中的类声明 : abstract class 类名
        //val user : User08 = new ChildUser08()

        //user.test

    }
}
// 抽象类
abstract class User08 {

    // 属性不完整: 只有声明而没有初始化
    // 编译后，其实没有属性，只有抽象方法
    var name : String

    // 抽象方法:不完整的方法
    def test
}

class ChildUser08 extends User08 {

    // 抽象属性补充完整
    var name : String = "zhangsan"

    // 补充完整的方法
    def test(): Unit = {
        println("xxxxx")
    }
}

