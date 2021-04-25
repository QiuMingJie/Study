package com.atguigu.bigdata.scala.chapter10

import scala.collection.mutable.ArrayBuffer

object Scala02_ScalaArray {

    def main(args: Array[String]): Unit = {

       // Scala同时支持不可变集合和可变集合


        // 声明数组
        // java : int[] i = new int[5]
        //        i[0] = 1
        //        println(i[0])
        // scala
        // scala中的数组可以声明类型（泛型）: 类型[泛型]

        // 创建数组
        //val array = new Array[Int](5)
        // 给数组的某个位置赋值：采用小括号来代替中括号
        // 设定数据
       //array(0) = 1

        // 获取单一数据
        //println(array(0))

        // 创建数组的同时增加数据
        // TODO 不可变数组
        val intArray = Array(1,2,3,4)
        //intArray.re
        //println(intArray)

        // 循环变量数组中的每一个元素
        /*
        for ( i <- intArray ) {
            println("i = " + i)
        }

        for (elem <- intArray) {

        }
        */

        /*
        def prt( i:Int ): Unit = {
            println("i = " + i)
        }
        */
        //intArray.foreach(prt)
        //intArray.foreach((x)=>{println(x)})
        //intArray.foreach(println(_))
        //intArray.foreach(println)

        // 数组的长度
        //intArray.length
        // 修改数据
        //intArray(1) = 5
        //intArray.update(1, 5)
        //intArray.foreach(println)

        // 生成字符串
        //val arrayString: String = intArray.mkString("-")
        //println(arrayString)

        // 给数组增加新的元素,等同于创建新的数组
        //val ints: Array[Int] = intArray :+ 6
        //ints.foreach(println)
        //println(intArray == ints)

        // TODO 可变数组
        val intArrayBuffer = ArrayBuffer(1,5,3,4)
        // 删除
        //intArrayBuffer.remove(1)
        //intArrayBuffer.remove(1,2)
        // 增加
        //intArrayBuffer.insert(2,7,8,9)
        // 修改
        //intArrayBuffer.update(1, 2)
        // 查询
        //println(intArrayBuffer(0))
        //for (elem <- intArrayBuffer) {}
        intArrayBuffer.foreach(println)

        // TODO 数组的转换

        // 不可变 ==> 可变
        intArray.toBuffer
        // 可变 ==> 不可变
        intArrayBuffer.toArray
   }
}
