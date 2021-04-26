package com.atguigu.bigdata.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming01_WordCount {

    def main(args: Array[String]): Unit = {

        // 使用SparkStreaming完成wordCount

        // 创建配置对象
        val sparkConf = new SparkConf().setAppName("SparkStreaming01_WordCount").setMaster("local[*]")

        // 创建SparkStreaming上下文环境对象
        // 构造函数的第二个参数表示数据的采集周期
        val context: StreamingContext = new StreamingContext(sparkConf, Seconds(3))

        // 从指定的端口获取数据
        val socketDStream: ReceiverInputDStream[String] = context.socketTextStream("linux1", 9999)

        // 将一行数据进行扁平化操作
        val wordDStream: DStream[String] = socketDStream.flatMap(line=>line.split(" "))

        // 将单词转换结构，便于统计
        val wordToOneDStream: DStream[(String, Int)] = wordDStream.map {
            word => (word, 1)
        }

        // 将转换后的结构数据进行统计
        val wordToSumDStream: DStream[(String, Int)] = wordToOneDStream.reduceByKey(_+_)

        // 打印结果
        wordToSumDStream.print()

        // 启动采集器
        context.start()

        // driver等待采集器的结束
        context.awaitTermination()
    }
}
