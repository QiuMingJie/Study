package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark20_Function {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[String] = sc.parallelize(Array("hadoop", "spark", "hive", "atguigu"))

        val search = new Search("h")

        //val filterRDD = search.getMatch1(rdd)

        //val filterRDD= rdd.filter(x=>x.contains("h"))

        val filterRDD: RDD[String] = search.getMatch2(rdd)
        filterRDD.foreach(println)

    }
}
class Search(query:String) {

    //过滤出包含字符串的数据
    def isMatch(s: String): Boolean = {
        s.contains(query)
    }

    //过滤出包含字符串的RDD
    def getMatch1(rdd: RDD[String]): RDD[String] = {
        rdd.filter(this.isMatch)
    }

    //过滤出包含字符串的RDD
    def getMatch2(rdd: RDD[String]): RDD[String] = {
        val q : String = this.query
        rdd.filter(x => x.contains(q))
    }

}
