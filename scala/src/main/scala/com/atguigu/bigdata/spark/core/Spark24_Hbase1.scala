package com.atguigu.bigdata.spark.core

import org.apache.hadoop.hbase.client.{Put, Result}
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.mapred.TableOutputFormat
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{Cell, CellUtil, HBaseConfiguration}
import org.apache.hadoop.mapred.JobConf
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark24_Hbase1 {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)

        // 访问Hbase
        val conf = HBaseConfiguration.create()

        val initialRDD = sc.parallelize(List(("1","apple"), ("2","banana"), ("3","pear")))

        // 保存到hbase中
        val jobConf = new JobConf(conf)
        jobConf.setOutputFormat(classOf[TableOutputFormat])
        jobConf.set(TableOutputFormat.OUTPUT_TABLE, "test")

        // Put
        val hbaseRDD: RDD[(ImmutableBytesWritable, Put)] = initialRDD.map {
            case (rk, name) => {
                val put = new Put(Bytes.toBytes(rk))
                put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes(name))
                (new ImmutableBytesWritable(Bytes.toBytes(rk)), put)
            }
        }

        hbaseRDD.saveAsHadoopDataset(jobConf)

        // 关闭资源
        sc.stop()
    }
}
