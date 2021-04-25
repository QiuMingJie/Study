package com.atguigu.bigdata.scala.chapter05

object Scala06_Function2 {

    def main(args: Array[String]): Unit = {

       def f1() = {
           val flg = true
           if ( flg ) {
               "Hello"
           } else {
               123
           }
       }

        f1
    }
}
