package com.atguigu.bigdata.scala.chapter10

import scala.collection.mutable.ListBuffer


object Scala03_ScalaSeq {

    def main(args: Array[String]): Unit = {

       // 序列 ： Seq
        // List
        val list = List(5,6,7,8,8,5)
        println(list)
        // 增加元素
        //list:+5

        // 空集合 : Nil
        //val list1: List[Nothing] = List()
        //println(Nil)
        // 增加数据
        // 扁平化：将一个整体拆分成一个一个的个体
        //val ints = 1::2::3::4::list:::Nil
        //println(ints)


        // 查询数据
        //println(5+:list)
        //list.foreach(println



        // TODO 可变序列
        val listBuff = ListBuffer(1,2,3,4)
        //listBuff.append()
        //listBuff.update()
        //listBuff.remove()
   }
}
