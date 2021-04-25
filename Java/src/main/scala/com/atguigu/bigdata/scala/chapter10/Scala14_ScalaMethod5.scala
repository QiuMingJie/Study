package com.atguigu.bigdata.scala.chapter10

import java.util

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Scala14_ScalaMethod5 {

    def main(args: Array[String]): Unit = {

        //val list = List( List(1,2), List(3,4) )

        //val list1 = List("Hello Scala", "Hello Spark")

        //println(list.flatMap(list => list))
        //println(list.flatMap(_))
        //list1.flatMap(line=>line.split(" "))
        //println(list1.flatMap(_.split(" ")))

        /*
        def numsForm(n: BigInt) : Stream[BigInt] = n #:: numsForm(n + 1)
        val stream1 = numsForm(1)
        println(stream1)
        println("head=" + stream1.head)
        println(stream1.tail)
        //println(stream1)
        */
//
//        def multiple(num: Int): Int = {
//            num
//        }
//
//        def eq(i: Int): Boolean = {
//            i.toString.equals(i.toString.reverse)
//        }
//
//        //说明: 没有使用view
//        val viewSquares1 = (1 to 100).map(multiple).filter(eq)
//        println(viewSquares1)
//
//        //使用view
//        val viewSquares2 = (1 to 100).view.map(multiple).filter(eq)
//        println(viewSquares2)

        val result1 = (0 to 100).map{case _ => Thread.currentThread.getName}
        val result2 = (0 to 100).par.map{case _ => Thread.currentThread.getName}
        println(result1)
        println(result2)


    }
}
