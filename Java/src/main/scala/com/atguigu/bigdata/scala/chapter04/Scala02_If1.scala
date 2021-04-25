package com.atguigu.bigdata.scala.chapter04

import java.util

object Scala02_If1 {

    def main(args: Array[String]): Unit = {

        var x = 4
        var y = 1
        if (x > 2) {
            if (y > 2)
                println(x + y)
                println("atguigu")
        } else
            println("x is " + x)


        val i = 10

        if ( i < 10 ) {
            println("<10")
        } else if ( i == 10 ) {
            println("=10")
        } else {
            println(">10")
        }

        val a = if (i == 10) {
            new Scala02_If1()
        } else {
            "123"
        }

        var sumVal = 60
        val result =     if(sumVal > 20){
            "结果大于20"
        }
        println(result)
    }
}
class Scala02_If1 {

}
