package com.atguigu.bigdata.scala.chapter09

// 隐式转换
object Scala01_ClassType1 {

    def main(args: Array[String]): Unit = {

        // 隐式转换：就是自动转化，当编译器发现程序无法完成编译时，查找自定义的转换规则，让程序可以完成编译
        //          这种方式有利于功能的扩展

        // 声明隐式转换规则 : double => int
        // 转换规则函数需要采用关键字声明
        implicit def transform(d:Double): Int = {
            d.toInt
        }

        val i : Int = 3.5

        println(i)

    }
}
