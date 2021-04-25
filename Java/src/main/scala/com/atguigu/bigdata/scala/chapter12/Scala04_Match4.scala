package com.atguigu.bigdata.scala.chapter12

object Scala04_Match4 {

    def main(args: Array[String]): Unit = {

        /*
        val (k, v) = (1, 2)
        //val tuple = (1,2)
        //tuple._2
        println(k + "=" + v)

        val list = List((1,2), (3, 4))

        for ((k,v) <- list) {
            println(k + "=" + v)
        }
        */

        /*
        val (q, r) = BigInt(10) /% 3  // 包含了2个连续的运算符
        println("q = " + q)
        println("r = " + r)
        */

        val arr = Array(1, 7, 2, 9)
        val Array(first, second, _*) = arr
        println(first, second)

        val list = List( ("a", 1), ("b", 2) )

        //list.map(t=>t._2)
        val ints: List[Int] = list.map {
            case (word, count) => {
                count
            }
        }
        println(ints)


    }
}
