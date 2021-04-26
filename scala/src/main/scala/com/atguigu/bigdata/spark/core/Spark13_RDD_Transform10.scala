package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark13_RDD_Transform10 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 构建RDD
        val kvRDD = sc.makeRDD(List(("a",3),("a",2),("c",4),("b",3),("c",6),("c",8)),2)


        // 转换算子 - aggregateByKey （使用key对数据进行聚合）
        // Scala中聚合都是在内存完成的。
        // RDD中的聚合都是分布式完成的。
        // aggregateByKey的第二个参数列表，表示分区内计算，分区间计算
        /* */
        //val aggregateRDD: RDD[(String, Int)] = kvRDD.aggregateByKey(10)(math.max(_,_),_+_)


        // 转换算子 - foldByKey （使用key对数据进行聚合）
        /* */
        //val foldRDD: RDD[(String, Int)] = kvRDD.foldByKey(0)(_+_)


        // 转换算子 - combineByKey
        val kvRDD1: RDD[(String, Int)] = sc.makeRDD(Array(("a", 88), ("b", 95), ("a", 91), ("b", 93), ("a", 95), ("b", 98)),2)

        //kvRDD.combineByKey(将第一个值进行结构的转换，第二个参数表示分区内计算规则，第三个参数表示分区间计算规则)
        /*
        kvRDD1.combineByKey{
            x=>(x,1),

            (t:(Int, Int), v:Int)=>{
                ( t._1 + v, t._2 + 1 )
            },
            (t1:(Int, Int), t2:(Int, Int)) => {
                ( t1._1 + t2._1, t1._2 + t2._2 )
            }
        }
        */

        val combineRDD: RDD[(String, (Int, Int))] = kvRDD1.combineByKey(
            x => (x, 1), // 将第一个数据进行结构的转换
            (t: (Int, Int), x) => { // 分区内的计算规则
                (t._1 + x, t._2 + 1)
            },
            (t1: (Int, Int), t2: (Int, Int)) => { // 分区间的计算规则
                (t1._1 + t2._1, t1._2 + t2._2)
            }
        )
        val resultRDD: RDD[(String, Int)] = combineRDD.map {
            case (key, (sum, count)) => {
                (key, sum / count)
            }
        }
        resultRDD.collect().foreach(println)



        //foldRDD.collect().foreach(println)
    }
}
