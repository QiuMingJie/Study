package com.atguigu.bigdata.scala.chapter09

// 隐式转换
object Scala03_ClassType3 {

    def main(args: Array[String]): Unit = {

        // 隐式变量
        implicit val str1: String = "rose"

        // 隐式参数
        def printx( implicit s : String = "tom" ): Unit = {
            println(s)
        }


        //printx("zhangsan")
        printx

    }
}
