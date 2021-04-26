package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark12_RDD_Transform9 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
        val kvRDD = sc.makeRDD(List( ("a",1),("b",2),("a",3),("b",4) ))

        /*
        // 转换算子 - groupByKey （使用key对数据进行分组）
        // 返回结果为元组 ：（key，相同key的value的集合）
        val groupRDD: RDD[(String, Iterable[Int])] = kvRDD.groupByKey()

        //groupRDD.collect().foreach(println)
        val mapRDD: RDD[(String, Int)] = groupRDD.map {
            case (key, datas) => {
                (key, datas.sum)
            }
        }
        mapRDD.collect().foreach(println)
        */

        // 转换算子 - reduceByKey ( 分组后聚合 )
        val reduceRDD: RDD[(String, Int)] = kvRDD.reduceByKey(_+_)
        reduceRDD.collect().foreach(println)

    }
}
