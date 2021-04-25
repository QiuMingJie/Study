package com.atguigu.bigdata.scala.chapter05

object Scala10_Exception {

    def main(args: Array[String]): Unit = {

        // scala中函数不需要抛出异常
        // scala中的异常捕捉是按照声明顺序
        try {
            val r = 10 / 0
        } catch {
            case ex: Exception => println("捕获了异常")
            case ex: ArithmeticException=> println("捕获了除数为零的算术异常")
        } finally {
                // 最终要执行的代码
                println("scala finally...")
        }

    }



}
