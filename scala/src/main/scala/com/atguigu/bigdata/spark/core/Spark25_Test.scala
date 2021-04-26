package com.atguigu.bigdata.spark.core

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.Put
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.mapred.TableOutputFormat
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.mapred.JobConf
import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

object Spark25_Test {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        // Spark提供了三大数据结构
        // 1. RDD : 分布式数据集
        // 2. 广播变量 : 分布式共享只读数据
        // 3. 累加器 : 分布式共享只写数据

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)

        val numRDD : RDD[Int] = sc.makeRDD(List(1,2,3,4))

        //val i: Int = numRDD.reduce(_+_)
        //val sum: Int = numRDD.collect.sum

        /* 数据操作有问题
        var sum = 0

        numRDD.foreach{
            num => {
                sum = sum + num
            }
        }

        println("sum = " + sum)
        */

        // 采用累加器实现操作
        // 声明累加器
        // 1. 创建累加器
        // 2. 将累加器注册到Spark环境中
        // 3. 使用累加器对象
        val sum: LongAccumulator = sc.longAccumulator("sum")

        numRDD.foreach{
            num => {
                // 使用累加器
                sum.add(num)
            }
        }

        // 获取累加器的结果
        println(sum.value)


        // 关闭资源
        sc.stop()
    }
}
