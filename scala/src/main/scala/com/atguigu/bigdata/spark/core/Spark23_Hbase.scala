package com.atguigu.bigdata.spark.core

import java.sql.{DriverManager, PreparedStatement}

import org.apache.hadoop.hbase.{Cell, CellUtil, HBaseConfiguration}
import org.apache.hadoop.hbase.client.Result
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.hbase.util.Bytes
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Spark23_Hbase {

    def main(args: Array[String]): Unit = {

        // 创建RDD

        val sparkConf = new SparkConf().setAppName("WordCount").setMaster("local")
        // 将当前创建Spark上下文环境对象的程序称之driver程序
        val sc = new SparkContext(sparkConf)

        // 访问Hbase
        val conf = HBaseConfiguration.create()
        conf.set(TableInputFormat.INPUT_TABLE, "test")

        val hbaseRDD: RDD[(ImmutableBytesWritable, Result)] = sc.newAPIHadoopRDD(
            conf,
            classOf[TableInputFormat],
            classOf[ImmutableBytesWritable],
            classOf[Result])

        val count: Long = hbaseRDD.count()
        println(count)

        hbaseRDD.foreach{
            case (rk, result) => {

                val cells: Array[Cell] = result.rawCells()
                for ( cell <- cells ) {
                    println(Bytes.toString(CellUtil.cloneQualifier(cell)) + ":" + Bytes.toString(CellUtil.cloneValue(cell)))
                }
            }
        }
        // 关闭资源
        sc.stop()
    }
}
