package com.atguigu.bigdata.scala.chapter10

import scala.collection.mutable

// 集合中常用的方法
object Scala11_ScalaMethod3 {

    def main(args: Array[String]): Unit = {

        var map1 = mutable.Map( "a"->2, "b"->2, "d"->2 )
        var map2 = mutable.Map( "a"->1, "b"->3, "c"->5 )

        val resultMap: mutable.Map[String, Int] = map1.foldLeft(map2) {
            (map, kv) => {

                // map访问操作
                val k = kv._1
                val v = kv._2

                // 更新map中key的值
                map(k) = map.getOrElse(k, 0) + v

                map
            }
        }

        println(resultMap)

    }
}
