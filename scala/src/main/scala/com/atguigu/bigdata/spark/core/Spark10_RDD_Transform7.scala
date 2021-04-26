package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object Spark10_RDD_Transform7 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
        val kvRDD = sc.makeRDD(List( ("a", 1), ("b", 2), ("c", 3), ("d", 4) ), 4)

        // 转换算子 - partitionBy - （分区，分区器）

        // 采用指定的分区器对数据进行重分区
        // 分区器的构造参数其实就是分区的数量

        // 分区器实现
        // 1. 继承抽象类Partitioner
        // 2. 重写抽象方法：numPartitions（获取分区数量），getPartition（根据key计算分区号）
        //val partitionByRDD: RDD[(String, Int)] = kvRDD.partitionBy(new org.apache.spark.HashPartitioner(2))
        val partitionByRDD: RDD[(String, Int)] = kvRDD.partitionBy(new MyPartitioner(3))

        //partitionByRDD.collect().foreach(println)
        val mapRDD: RDD[(Int, (String, Int))] = partitionByRDD.mapPartitionsWithIndex {
            (ind, datas) => {
                datas.map {
                    (ind, _)
                }
            }
        }
        mapRDD.collect().foreach(println)

    }
}
// 自定义分区器
class MyPartitioner(num:Int) extends Partitioner {
    // 分区数量
    override def numPartitions: Int = num

    // 根据key计算分区号
    override def getPartition(key: Any): Int = {
        1
    }
}
