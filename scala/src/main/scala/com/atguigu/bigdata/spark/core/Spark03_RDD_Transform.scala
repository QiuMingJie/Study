package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark03_RDD_Transform {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
        val numRDD: RDD[Int] = sc.makeRDD(List(1,2,3,4),2)

        // RDD转换算子 - map
        //val mapRDD: RDD[Int] = numRDD.map(x=>x*2)
        val mapRDD: RDD[Int] = numRDD.map(_*2)

        mapRDD.collect().foreach(println)

        // RDD转换算子 - mapPartitions,把整个partition作为一个整体进行运算，一般来说效率比map高，不过可能出现oom
        val mapPartitionsRDD: RDD[Int] = numRDD.mapPartitions{
            datas => {
                datas.map(_*2)
            }
        }
        mapPartitionsRDD.collect().foreach(println)

        //  RDD转换算子 - mapPartitionsWithIndex
        val mapPartitionsWithIndexRDD: RDD[(Int, Int)] = numRDD.mapPartitionsWithIndex {
            (ind, datas) => {
                datas.map((ind, _))
            }
        }
        mapPartitionsWithIndexRDD.collect().foreach(println)
    }
}
