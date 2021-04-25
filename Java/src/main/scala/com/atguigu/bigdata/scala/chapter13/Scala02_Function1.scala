package com.atguigu.bigdata.scala.chapter13

object Scala02_Function1 {

    def main(args: Array[String]): Unit = {

        // 偏函数：只对一部分数据进行处理的函数称之偏函数

        /*
        val list = List(1, 2, 3, 4, "abc")
        // 偏函数其实是一个trait,实现时，需要重写isDefinedAt，apply方法，这两个方法类似于filter, map方法
        val addOne3= new PartialFunction[Any, Int] {
            def isDefinedAt(any: Any) = {
                if (any.isInstanceOf[Int]) true
                else false
            }
            def apply(any: Any) = any.asInstanceOf[Int] + 1
        }

        // 收集，采集
        val list3 = list.collect(addOne3)
        // map方法必须为全量数据操作，不允许使用偏函数
        list.map(addOne3)
        println("list3=" + list3)
        */

        println(List(1, 2, 3, 4, "abc").collect{case i:Int=>i+1})


    }
}
