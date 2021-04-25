package com.atguigu.bigdata.scala.chapter10

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


object Scala04_ScalaSet {

    def main(args: Array[String]): Unit = {

        // 集 ： Set ， 无序，不可重复
        // 创建集合
        val intSet = Set(1,2,3,4,5,6,1,2,4,3)

        //intSet + 9
        //intSet - 2

        //println(intSet - 2)
        //for (elem <- intSet) {}
        //intSet.foreach()
        //intSet.mkString(",")

        // TODO 可变集合
        val set = mutable.Set(1,2,3,4,5,6)
        //set.remove()
        //set.update()
        set.add(7)
        println(set)
    }
}
