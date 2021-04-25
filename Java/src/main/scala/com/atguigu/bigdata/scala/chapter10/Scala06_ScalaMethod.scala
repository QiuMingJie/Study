package com.atguigu.bigdata.scala.chapter10

// 集合中常用的方法
object Scala06_ScalaMethod {

    def main(args: Array[String]): Unit = {

        //val list = List(1,4,3,2,2,3)

        //println(list.size)
        // 集合的头部
        //println(list.head)
        // 集合的尾部
        //println(list.tail)
        // 集合的最后一个
        //println(list.last)
        // 集合除了最后一个
        //println(list.init)

        //println(list.max)
        //println(list.min)
        //println(list.sum)
        //println(list.product)

        // TODO Filter
        // 过滤 : true表示保留数据，false表示过滤数据
        //val ints: List[Int] = list.filter(x=>x%2==0)
        //println(ints)

        /* TODO Sort
        val ints: List[Int] = list.sortWith {
            (left, right) => {
                left > right
            }
        }
        println(ints)

        // 1,2,3,4 => 1,0,1,0
        //val ints: List[Int] = list.sortBy(x=>x%2)
        //println(ints)
        */

        // TODO Group
        // 按照逻辑的返回结果
        //val intToInts: Map[Int, List[Int]] = list.groupBy( x=>x%2 )
        //println(intToInts)

        //val stringList = List("Hello", "Scala", "Spark", "Hbase")
        //val stringToStrings: Map[String, List[String]] = stringList.groupBy(word=>word.substring(0,1))

        //println(stringToStrings)

        // TODO map(映射) ==》 （word, count）("Hello", 5),("Hello", 10)
        //val stringList = List("Hello", "Scala", "Spark", "Hbase")

        //println(stringList.map(word => (word, 1)))
        //println(stringList.map(word => word*2))

        // TODO flatMap : 扁平化
        val intses = List(List(1,2),List(3,4),List(5,6))
        // 1,2,3,4,5,6
        intses.flatMap(x=>x).foreach(println)
            //.foreach(println)

    }
}
