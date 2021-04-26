package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark01_WordCount {

    def main(args: Array[String]): Unit = {

        // TODO 开发第一个Spark框架的wordcount

        // TODO 0. 创建环境配置对象
        // 默认为本地环境
        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local[*]")

        // TODO 1. 创建Spark上下文环境对象
        val sc = new SparkContext(sparkConf)

        // TODO 2. 读取文件,项目root路径
        val files: RDD[String] = sc.textFile("input")

        // TODO 3. 将文件中每行数据进行扁平化操作
        val words: RDD[String] = files.flatMap(_.split(" "))

        // TODO 4. 将单词进行结构的转换
        val wordToOne: RDD[(String, Int)] = words.map( (_, 1) )

        // TODO 5. 将相同的单词进行聚合
        val result: RDD[(String, Int)] = wordToOne.reduceByKey(_+_)

        // TODO 6. 采集数据
        val tuples: Array[(String, Int)] = result.collect()

        tuples.foreach(println)

    }
}
