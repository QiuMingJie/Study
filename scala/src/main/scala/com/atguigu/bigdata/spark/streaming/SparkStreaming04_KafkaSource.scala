package com.atguigu.bigdata.spark.streaming

import java.io.{BufferedReader, InputStreamReader}
import java.net.Socket

import kafka.serializer.StringDecoder
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming04_KafkaSource {

    def main(args: Array[String]): Unit = {

        // 从kafka中获取数据

        val sparkConf = new SparkConf().setAppName("SparkStreaming01_WordCount").setMaster("local[*]")
        val context: StreamingContext = new StreamingContext(sparkConf, Seconds(3))

        val kafkaDStream: ReceiverInputDStream[(String, String)] = KafkaUtils.createStream[String, String, StringDecoder, StringDecoder](
            context,
            Map(
                ConsumerConfig.GROUP_ID_CONFIG -> "atguigu",
                "zookeeper.connect" -> "linux1:2181",
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer",
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> "org.apache.kafka.common.serialization.StringDeserializer"
            ),
            Map("atguigu"->3),
            StorageLevel.MEMORY_ONLY
        )

        val lineDStream: DStream[String] = kafkaDStream.map(_._2)

        val wordDStream: DStream[String] = lineDStream.flatMap(_.split(" "))

        val wordToOneDStream: DStream[(String, Int)] = wordDStream.map((_, 1))

        val wordToSumDStream: DStream[(String, Int)] = wordToOneDStream.reduceByKey(_+_)

        wordToSumDStream.print()

        // 启动采集器
        context.start()

        // driver等待采集器的结束
        context.awaitTermination()
    }
}