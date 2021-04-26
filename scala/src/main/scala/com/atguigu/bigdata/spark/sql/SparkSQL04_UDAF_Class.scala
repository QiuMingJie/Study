package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.{Aggregator, MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DoubleType, LongType, StructType}
import org.apache.spark.sql.{Encoder, _}



object SparkSQL04_UDAF_Class {

    def main(args: Array[String]): Unit = {

        // 用户自定义聚合函数(强类型) ： UDAF

        // 创建配置对象
        val sparkConf = new SparkConf().setAppName("SparkSQL01_Demo").setMaster("local[*]")

        // SparkSQL上下文环境对象
        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
        // 将RDD转换DF, DS时，需要进行隐式转换，所以需要导入相应的功能
        // 下面的导入语句，即使不使用，也最好加上。
        import sparkSession.implicits._

        // 创建聚合函数对象
        val udaf = new AgeAvgClassUDAF
        // 将函数转换为查询的列
        val col: TypedColumn[User04, Double] = udaf.toColumn.name("ageAvg")

        // 准备数据
        val df: DataFrame = sparkSession.read.json("input/user.json")

        // 使用DSL语法访问数据
        val ds: Dataset[User04] = df.as[User04]
        ds.select(col).show()


        // 释放资源
        sparkSession.stop()
    }
}

case class User04( username:String, age:Long )
case class AgeAvgBuf( var sum:Long, var count:Long )

// 声明聚合函数（强类型）
// 继承Aggregator
// 声明泛型,in, buf, out
// 重写方法
class AgeAvgClassUDAF extends Aggregator[User04, AgeAvgBuf, Double] {

    // 缓冲区初始化
    override def zero: AgeAvgBuf = {
        AgeAvgBuf(0, 0)
    }

    // 更新缓冲区数据
    override def reduce(buffer: AgeAvgBuf, user: User04): AgeAvgBuf = {
        buffer.sum = buffer.sum + user.age
        buffer.count = buffer.count + 1
        buffer
    }

    // 合并缓冲区数据
    override def merge(b1: AgeAvgBuf, b2: AgeAvgBuf): AgeAvgBuf = {

        b1.sum = b1.sum + b2.sum
        b1.count = b1.count + b2.count

        b1
    }

    // 计算结果
    override def finish(reduction: AgeAvgBuf): Double = {
        reduction.sum.toDouble / reduction.count
    }

    override def bufferEncoder: Encoder[AgeAvgBuf] = Encoders.product

    override def outputEncoder: Encoder[Double] = Encoders.scalaDouble
}