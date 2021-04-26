package com.atguigu.bigdata.spark.streaming

import java.io.{BufferedReader, InputStreamReader}
import java.net.Socket

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

object SparkStreaming03_MyRecevier {

    def main(args: Array[String]): Unit = {

        // 自定义采集器采集数据

        // 创建配置对象
        val sparkConf = new SparkConf().setAppName("SparkStreaming01_WordCount").setMaster("local[*]")

        // 创建SparkStreaming上下文环境对象
        // 构造函数的第二个参数表示数据的采集周期
        val context: StreamingContext = new StreamingContext(sparkConf, Seconds(3))

        // 采用自定义采集器采集数据
        val myDStream: ReceiverInputDStream[String] = context.receiverStream(new MyReceiver( "linux1", 9999 ))

        // 将一行数据进行扁平化操作
        val wordDStream: DStream[String] = myDStream.flatMap(line=>line.split(" "))

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
// 声明采集器
class MyReceiver( host:String, port:Int ) extends Receiver[String](StorageLevel.MEMORY_ONLY) {

    var socket: Socket = _

    // 接收数据
    def receive(): Unit = {
        socket = new Socket(host, port)
        val reader = new BufferedReader(new InputStreamReader(socket.getInputStream, "UTF-8"))
        var line:String = null
        while ( (line = reader.readLine()) != null ) {
            if ( "==END==".equals(line) ) {
                return
            } else {
                // 存储数据
                store(line)
            }
        }
    }

    override def onStart(): Unit = {
        new Thread(new Runnable {
            override def run(): Unit = {
                receive()
            }
        }).start
    }

    override def onStop(): Unit = {
        if ( socket != null ) {
            socket.close()
            socket = null
        }
    }
}