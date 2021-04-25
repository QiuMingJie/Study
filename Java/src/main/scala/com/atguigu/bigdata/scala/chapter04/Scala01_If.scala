package com.atguigu.bigdata.scala.chapter04

object Scala01_If {

    def main(args: Array[String]): Unit = {

        val flg = false

        // 表达式有结果
        val result = if ( flg ) {
            println("true")
        } else {
            println("false")
        }

        println(result)
    }
}
