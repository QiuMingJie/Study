package com.atguigu.bigdata.scala.chapter060708

import java.util.Date

import scala.beans.BeanProperty

// 面向对象 - 类型转换
object Scala16_Class5 {
    def main(args: Array[String]): Unit = {

        println(ColorX.BLUE)

    }
}
// 枚举
object ColorX extends Enumeration {
    var RED = Value(1, "red")
    var BLUE = Value(2, "blue")
}
