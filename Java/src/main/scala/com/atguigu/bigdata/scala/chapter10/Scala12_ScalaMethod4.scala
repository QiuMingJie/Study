package com.atguigu.bigdata.scala.chapter10

import scala.collection.mutable

// 集合中常用的方法
object Scala12_ScalaMethod4 {

    def main(args: Array[String]): Unit = {

        val list1 = List(1,2,3,4)
        val list2 = List(4,5,6,7,8)

        //println(list1 ::: list2)
        // 集合的并集
        val ints: List[Int] = list1.union(list2)
        //println(ints)

        //集合的交集
        val ints1: List[Int] = list1.intersect(list2)
       // println(ints1)

        // 集合的差集
        val ints2: List[Int] = list2.diff(list1)
        //println(ints2)

        // 需要满足两个集合的元素是相同，如果不相同，那么多余的数据无法实现拉链效果
        val tuples: List[(Int, Int)] = list1.zip(list2)
        //println(tuples)

        val numList = List(1,2,3,4,5,6,7,8)

        // 滑动
        // 以指定大小的数据范围作为一个整体,将这个整体称之窗口，将其中的数据称之为窗口数据
        // 当实现数据循环时，窗口会进行滑动,默认滑动的步长为1，将这个操作称之为滑动窗口函数
        //val intses: Iterator[List[Int]] = numList.sliding(3)
        val intses: Iterator[List[Int]] = numList.sliding(3,2)

        for (elem <- intses) {
            //println(elem)
        }

        // 扫描
        //println(list1.scan(0)(_ - _))
        //println(list1.scanRight(0)(_ - _))

        //list1.

    }
}
