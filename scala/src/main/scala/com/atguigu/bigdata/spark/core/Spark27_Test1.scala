package com.atguigu.bigdata.spark.core

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

object Spark27_Test1 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        // Spark提供了三大数据结构
        // 1. RDD : 分布式数据集
        // 2. 广播变量 : 分布式共享只读数据
        // 3. 累加器 : 分布式共享只写数据

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local[4]")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)

        // (1, (1,4))
        val kvRDD1 = sc.makeRDD(List( (1,1), (2,2), (3,3) ))
        val kvRDD2 = sc.makeRDD(List( (1,4), (2,5), (3,6) ))

        kvRDD2.reduceByKey(_+_)

        val joinRDD: RDD[(Int, (Int, Int))] = kvRDD1.join(kvRDD2)
        joinRDD.foreach(println)

        // 如果将集合直接传递给Executor执行，那么每一个任务都会传递一份，会造成内存数据冗余
        // 使用广播变量进行优化，可以在Executor只保留一份数据，这个Executor中执行的所有任务可以共享这份数据
        /*
        val list = List((1,4), (2,5), (3,6) )

        // 声明广播变量
        val broadcastList: Broadcast[List[(Int, Int)]] = sc.broadcast(list)

        val joinRDD: RDD[(Int, (Int, Any))] = kvRDD1.map {
            case (k1, v1) => {
                var v: Any = null
                // 获取广播变量的值
                for ((k2, v2) <- broadcastList.value) {
                    if (k1 == k2) {
                        v = v2
                    }
                }
                (k1, (v1, v))
            }
        }
        joinRDD.foreach(println)
        */


        // 关闭资源
        sc.stop()
    }
}
