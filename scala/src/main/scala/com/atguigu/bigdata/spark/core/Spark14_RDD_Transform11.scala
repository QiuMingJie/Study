package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark14_RDD_Transform11 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
        val kvRDD1 = sc.makeRDD(Array((1,"a"),(2,"b"),(3,"c")))
        val kvRDD2 = sc.makeRDD(Array((1,4),(2,5),(3,6),(4,7)))

        // 转换算子 - sortByKey
        //kvRDD.sortByKey(false).collect().foreach(println)

        // 转换算子 - mapValues
        //kvRDD.mapValues(v=>{v+"|||"}).collect().foreach(println)

        // 转换算子 - join (相同key聚合,将value连接在一起：(key, (v1, v2))  )
        //val joinRDD: RDD[(Int, (String, Int))] = kvRDD1.join(kvRDD2)

        // 转换算子 - cogroup
        //val cogroupRDD: RDD[(Int, (Iterable[Int], Iterable[String]))] = kvRDD2.cogroup(kvRDD1)

        //cogroupRDD.collect().foreach(println)
    }
}
