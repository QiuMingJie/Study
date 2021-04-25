package com.atguigu.bigdata.scala.chapter03

import scala.io.StdIn

object Scala04_In {

    def main(args: Array[String]): Unit = {

        // 标准化输入
        //val line: String = StdIn.readLine()
        val age = StdIn.readInt()

        println("age = " + age)
    }
}
