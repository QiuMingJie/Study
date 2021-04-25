package com.atguigu.bigdata.scala.chapter10

// 集合中常用的方法
object Scala10_ScalaMethod2 {

    def main(args: Array[String]): Unit = {

        val ints = List(1,2,3,4)

        // 折叠 : 也可以简单的理解化简的特殊情况，聚合数据。
        // 折叠操作使用了函数柯里化，含有两个参数列表
        // 第一个参数列表表示运算初始值：零值
        // 第二个参数列表表示运算规则
        //val result: Int = ints.fold(10)(_+_)
        //val result: Int = ints.fold(10)(_-_)
        // 从源码的角度来讲，其实fold操作就是foldLeft
        //val result: Int =  ints.foldLeft(10)(_-_)

        // 4,3,2,1
        // z - 4 ==> 3 - (4 - z) ==> 2 - (3 - (4 - z)) ==> 1 - (2 - (3 - (4 - 10))),
        val result: Int =  ints.foldRight(10)(_-_)

        println(result)

    }
}
