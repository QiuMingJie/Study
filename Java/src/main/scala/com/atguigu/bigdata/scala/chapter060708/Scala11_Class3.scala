package com.atguigu.bigdata.scala.chapter060708

import java.util.Date

import scala.beans.BeanProperty

// 面向对象 - 类
object Scala11_Class3 {
    def main(args: Array[String]): Unit = {

        val user = new User11("zhangsan")

        user.namex = "12323"
    }
}

// 可以在构造方法参数中增加关键字，var|val,可以将指定的参数作为类的属性
class User11( var namex : String ) {
    //var name : String = namex
}


