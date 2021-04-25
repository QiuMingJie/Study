package com.atguigu.bigdata.scala.chapter10

// WordCount
object Scala07_WordCount {

    def main(args: Array[String]): Unit = {

        // 对单词进行出现次数的数据统计，从大到小进行排序，取前三名
        val stringList = List("Hello Scala Spark Hadoop", "Hello Scala Spark", "Hello Scala", "Hello")

        // 将集合中的每一条数据进行扁平化操作
        val wordList: List[String] = stringList.flatMap(str=>str.split(" "))

        // 将相同的单词放在一起（分组）
        val wordToWords: Map[String, List[String]] = wordList.groupBy(word=>word)

        // 将分组后的数据进行结构的转换 ：word-List ==> (word, count)
        val wordToCount: Map[String, Int] = wordToWords.map {
            (kv) => {
                (kv._1, kv._2.size)
            }
        }

        // 将转换结构后的数据进行排序（降序）
        val wordToCountSortList: List[(String, Int)] = wordToCount.toList.sortWith {
            (left, right) => {
                left._2 > right._2
            }
        }

        // 获取集合的前三名
        val resultList: List[(String, Int)] = wordToCountSortList.take(3)

        println(resultList)



    }
}
