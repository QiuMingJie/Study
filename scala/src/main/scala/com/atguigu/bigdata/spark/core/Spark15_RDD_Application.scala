package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark15_RDD_Application {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        val sc = new SparkContext(sparkConf)

        // 使用算子完成需求：统计出每一个省份广告被点击次数的TOP3
        // TODO 1. 数据事先已经准备好了。直接读取文件
        //         时间戳，省份，城市，用户，广告
        val lineRDD: RDD[String] = sc.textFile("input/agent.log")

        // TODO 2. 将数据进行分解，保留省份，广告。
        val prvAdvToClickRDD: RDD[(String, Int)] = lineRDD.map {
            line => {
                val datas: Array[String] = line.split(" ")
                //(datas(1), datas(4))
                (datas(1) + "_" + datas(4), 1)
            }
        }

        // TODO 3. 将数据按照 (省份 + 广告) 进行统计点击次数
        val prvAdvToSumClickRDD: RDD[(String, Int)] = prvAdvToClickRDD.reduceByKey(_+_)

        // TODO 4. 统计结果为：（省份+广告，sumClick）,使用省份进行分组
        // TODO 4.1 将数据转化结构（省份，（广告，sumClick））
        val prvToAdvAndSumClickRDD: RDD[(String, (String, Int))] = prvAdvToSumClickRDD.map {
            case (prvAdv, sumClick) => {

                val keys: Array[String] = prvAdv.split("_")

                (keys(0), (keys(1), sumClick))
            }
        }
        // TODO 4.2 根据省份分组
        val groupRDD: RDD[(String, Iterable[(String, Int)])] = prvToAdvAndSumClickRDD.groupByKey()

        // TODO 5. 将分组后的广告信息进行排序(降序)，保留前三
        val resultRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(datas => {
            datas.toList.sortWith {
                (left, right) => {
                    left._2 > right._2
                }
            }.take(3)
        })

        resultRDD.collect().foreach(println)

    }
}
