package com.atguigu.bigdata.scala.chapter04

import scala.util.control.Breaks._

object Scala05_Break {

    def main(args: Array[String]): Unit = {

        // scala模仿break操作,使用类的方法实现
        var i = 0
        breakable{
            while ( i < 10 ) {
                if ( i == 5 ) {
                    break;
                }

                i=i+1;
            }
        }

        println("i = " + i)

    }
}
