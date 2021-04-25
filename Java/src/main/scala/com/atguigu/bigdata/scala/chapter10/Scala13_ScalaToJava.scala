package com.atguigu.bigdata.scala.chapter10

import java.util

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Scala13_ScalaToJava {

    def main(args: Array[String]): Unit = {

        val arr = ArrayBuffer("1", "2", "3")

        import scala.collection.JavaConversions.bufferAsJavaList

        val javaArr = new ProcessBuilder(arr)
        val arrList: util.List[String] = javaArr.command()

        //println(arrList)

        import scala.collection.JavaConversions.asScalaBuffer
        val scalaArr: mutable.Buffer[String] = arrList

        scalaArr.append("jack")
        println(scalaArr)

        //val list1 = List(1, 2, 3, "abc")
        //val list5 = 4 :: 5 :: 6 :: list1
        //println(list5)

        //val list1 = List(1, 2, 3, "abc")
        //val list5 = 4 :: 5 :: 6 :: list1 :: 9
        //println(list5)

        //val list1 = List(1, 2, 3, "abc")
        //val list5 = 4 :: 5 :: 6 :: list1 ::: Nil
        //println(list5)

        //val list1 = List(1, 2, 3, "abc")
        //val list5 = 4 :: 5 :: list1 :: list1 :: Nil
        //println(list5)

        /*
        val queue = new mutable.Queue[Int]

        queue.enqueue(1,2,3,4)

        println(queue.dequeue())
        println(queue)
        */

        /*
        val map = Map(("a", 1), ("b", 2))

        //println(map("c"))
        println(map.getOrElse("c", 0))
        //map.ge
        */

        val map4 = mutable.Map( ("A", 1), ("B", "北京"), ("C", 3) )
        map4 += ( "D" -> 4 )
        map4 += ( "B" -> 50, "E" -> 10 )
        println(map4)

        //map4.keys
        //map4.values



    }
}
