package com.atguigu.bigdata.scala.chapter060708

import java.util.Date

import scala.beans.BeanProperty

// 面向对象 - 类的方法
object Scala06_Method {
    def main(args: Array[String]): Unit = {

        //val user = new User06
        //val user = User06
        val user = User06("zhangsan")

        println(user)

       // user.test()

        for ( i <- Range(1,5, 2) ) {

        }

    }
}
class User06 {
    // 类的方法其实就是函数,只不过声明在类的内部，需要同通过对象的方式调用
    def test(): Unit = {

    }
}
object User06 {
    // 应用方法，当构建对象不使用new的方式时，scala会自动调用方法
    // 创建对象，但是对象可以是其他类型
    // 一般情况下，用于构建伴生类对象
    def apply = new User06()

    def apply( s : String ) = new User06()
}
