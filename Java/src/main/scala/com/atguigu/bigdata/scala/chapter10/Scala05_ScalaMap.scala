package com.atguigu.bigdata.scala.chapter10

import scala.collection.mutable

object Scala05_ScalaMap {

    def main(args: Array[String]): Unit = {

        // 映射集合 ： K-V
        var map = Map( "a"->1, "b"->2, "c"->3, "d"->4, "e"->5 )
        //var map = Map( ("a", 1), ("b", 2) )
        //val map1 = mutable.Map("a"->1, "b"->2, "c"->3, "d"->4, "e"->5)

        // 获取数据
        //println(map)
        // Option(选项):Some,None
        // 从Map中获取数据，需要考虑空指针异常，所以Scala对结果进行封装，形成了特殊对象
        // 通过调用对象的方法获取值或默认值
        //println(map.get("b").getOrElse(0))
        //println(map1)
        /*
        for (elem <- map) {
            // 获取每一个元素
            //println(elem)
            // (a,1) => （k-v对）对偶
            println(elem._1 + "=" + elem._2)
        }
        */
        //map.foreach((x)=>{println(x)})
        //val map1 = map + ("k", 10)
        //map ++ ("k"->7)
        //println(map - ("a", "b"))
        //map.updated("b", 6)
        //println(map.updated("b", 6))

        // Scala可以将无关数据封装成一个整体，这个整体称之Tuple(元组)
        // 声明元组的方式：小括号

        // 元组中元素的个数最多只能放置22个
        // 函数的参数列表最多也只能放22个
        //val tuple: (Int, String, String, String) = ( 20, "zhangsan", "1", "北京" )

        // 使用顺序号访问元组中的数据
        //println(tuple._1)

        /*
        val iterator: Iterator[Any] = tuple.productIterator

        while ( iterator.hasNext ) {
            iterator.next()
        }*/
        //println(tuple.productElement(2))

        // 如果元组中的元素只有2个，称之为对偶
        //map.foreach((x)=>{println(x._1 + "=" + x._2)})

        // 模式匹配
        map.foreach{
            case (k, v)=>{
                println(k + "=" + v)
            }
        }

    }
}
// 多个数据之间如果存在关系，那么可以将这些数据封装成对象
// 无关的数据无法封装成对象
/*
class User {
    val name : String = _
    val password : String = _
}
*/
// 20, "zhangsan", "1", "北京"
