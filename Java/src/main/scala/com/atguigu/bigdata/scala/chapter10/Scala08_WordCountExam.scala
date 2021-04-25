package com.atguigu.bigdata.scala.chapter10

// WordCount
object Scala08_WordCountExam {

    def main(args: Array[String]): Unit = {

        //
        val list = List(("Hello Scala Spark World", 4), ("Hello Scala Spark", 3), ("Hello Scala", 2), ("Hello", 1))

        // Hello Scala Spark World Hello Scala Spark WorldHello Scala Spark WorldHello Scala Spark World

        // 将集合中数据的结构进行转换
        //val strings: List[String] = list.map(t=>{ (t._1 + " ")*t._2 })
        // 扁平化
        //strings.flatMap(str=>{str.split(" ")})
        //val wordList: List[String] = strings.flatMap(_.split(" "))

        // 第二种
        //    ("Hello Scala Spark World ", 4)
        //==> ( Hello, Scala, Spark, World )
        //==> ( (Hello, 4), (Scala, 4), (Spark, 4), (World, 4), (Hello, 3) )
        val wordToCountList: List[(String, Int)] = list.flatMap {
            t => {
                val line = t._1
                val words = line.split(" ")
                words.map((_, t._2))
            }
        }
        //==> ( Hello -> List( (Hello, 4), (Hello, 3), (Hello, 2)  ) )
        val wordToList: Map[String, List[(String, Int)]] = wordToCountList.groupBy(_._1)
        //==> (Hello  -> List(4,3,2,1))
        //==> (Hello -> 10)
        /*
        val wordToTotalCountMap: Map[String, Int] = wordToList.map {
            t => {
                val wordToCountList1 = t._2
                val ints: List[Int] = wordToCountList1.map(_._2)
                (t._1, ints.sum)
            }
        }
        */

        // 如果只关心value的数据，不关心key，那么可以采用mapValues方法
        // (Hello, List) ==> mapValues ==> (Hello, sum)
        val wordToTotalCountMap: Map[String, Int] = wordToList.mapValues(datas=>{datas.map(_._2).sum})


        //==> sort
        val resultList: List[(String, Int)] = wordToTotalCountMap.toList.sortWith {
            (left, right) => {
                left._2 > right._2
            }
        }.take(3)

        println(resultList)



    }
}
