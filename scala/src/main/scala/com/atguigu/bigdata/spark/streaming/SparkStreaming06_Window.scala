package com.atguigu.bigdata.spark.streaming

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming06_Window {

    def main(args: Array[String]): Unit = {


        /*
        val ints = List(1,2,3,4,5,6,7,8)

        // 滑动窗口
        // 将数据的一部分作为一个整体（范围），称之为窗口
        // 将这个窗口中的数据，称之为窗口数据
        // 将对这个窗口中的数据进行操作的函数，称之为窗口函数
        val intses: Iterator[List[Int]] = ints.sliding(3, 2)

        for ( as <- intses ) {
            println(as)
        }
        */

        // 创建配置对象
        val sparkConf = new SparkConf().setAppName("SparkStreaming01_WordCount").setMaster("local[*]")

        // 创建SparkStreaming上下文环境对象
        // 构造函数的第二个参数表示数据的采集周期
        val context: StreamingContext = new StreamingContext(sparkConf, Seconds(3))

        // 从指定的端口获取数据
        val socketDStream: ReceiverInputDStream[String] = context.socketTextStream("linux1", 9999)

        // 将多个采集周期当成一个整体来使用，称之为窗口
        // 最近XXX时间内的数据显示
        // 窗口的大小和窗口滑动的步长应该为采集周期的整数倍
        val windowDStream: DStream[String] = socketDStream.window(Seconds(5),Seconds(5))

        // 将一行数据进行扁平化操作
        val wordDStream: DStream[String] = windowDStream.flatMap(line=>line.split(" "))

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
