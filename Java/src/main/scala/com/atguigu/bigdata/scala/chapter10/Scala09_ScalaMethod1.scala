package com.atguigu.bigdata.scala.chapter10

import scala.collection.mutable.ListBuffer

// 集合中常用的方法
object Scala09_ScalaMethod1 {

    def main(args: Array[String]): Unit = {

        val ints = List(1,2,3,4)


        // 化简： 将多个数据进行逻辑运算，简化为一个结果，具体的结果取决于运算的规则
        //
        //val result: Int = ints.reduce((x,y)=>x+y)
        val result: Int = ints.reduce(_+_)
        println(result)
        // 从源码的角度来讲，其实reduce操作就是reduceLeft
        //val result: Int = ints.reduce(_-_)

        //val result1: Int = ints.reduceLeft(_-_)
        //val result2: Int = ints.reduceRight(_-_)


        //println("r = " + result2)
        // 4,3,2,1
        //println(ints.reverse)

    }
}
