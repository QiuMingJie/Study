package com.atguigu.bigdata.spark.core

import java.util

import org.apache.spark.rdd.RDD
import org.apache.spark.util.{AccumulatorV2, LongAccumulator}
import org.apache.spark.{SparkConf, SparkContext}

object Spark26_Accumulator {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        // 使用累加器完成黑名单的数据处理

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)

        val wordRDD : RDD[String] = sc.makeRDD(List("hello", "hadoop", "spark", "scala"))

        // 创建累加器
        val accumulator = new BlackListAccumulator
        // 注册累加器
        sc.register(accumulator, "blackList")

        wordRDD.foreach{
            word=>{
                accumulator.add(word)
            }
        }

        // 获取累加器的值
        println(accumulator.value)

        // 关闭资源
        sc.stop()
    }
}
// 声明累加器
class BlackListAccumulator extends AccumulatorV2[String, util.HashSet[String]] {

    // 黑名单集合
    var blackSet = new util.HashSet[String]

    // 判断当前的累加器是否为初始状态
    override def isZero: Boolean = {
        blackSet.isEmpty
    }

    // 复制累加器
    override def copy(): AccumulatorV2[String, util.HashSet[String]] = {
        new BlackListAccumulator()
    }

    // 重置累加器
    override def reset(): Unit = {
        blackSet.clear()
    }

    // 增加数据
    override def add(v: String): Unit = {
        if ( v.contains("h") ) {
            blackSet.add(v)
        }
    }

    // 合并累加器
    override def merge(other: AccumulatorV2[String, util.HashSet[String]]): Unit = {
        blackSet.addAll(other.value)
    }

    // 累加器的值
    override def value: util.HashSet[String] = {
        blackSet
    }
}
