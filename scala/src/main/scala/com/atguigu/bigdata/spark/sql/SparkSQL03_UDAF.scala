package com.atguigu.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DoubleType, LongType, StructType}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}



object SparkSQL03_UDAF {

    def main(args: Array[String]): Unit = {

        // 用户自定义聚合函数 ： UDAF

        // 创建配置对象
        val sparkConf = new SparkConf().setAppName("SparkSQL01_Demo").setMaster("local[*]")

        // SparkSQL上下文环境对象
        val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
        // 将RDD转换DF, DS时，需要进行隐式转换，所以需要导入相应的功能
        // 下面的导入语句，即使不使用，也最好加上。
        import sparkSession.implicits._

        // 创建聚合函数
        val udaf = new AgeAvgUDAF()
        // 注册函数
        sparkSession.udf.register("ageAvg", udaf)

        // 准备数据
        val df: DataFrame = sparkSession.read.json("input/user.json")

        df.createTempView("user")

        // 使用SQL访问数据
        sparkSession.sql("select ageAvg(age) from user").show

        // 释放资源
        sparkSession.stop()
    }
}
// 声明聚合函数
// 继承UserDefinedAggregateFunction
// 重写方法
// 需要通过聚合函数保存中间的变量，然后再计算最终的结果
// select avg(age) from user
class AgeAvgUDAF extends UserDefinedAggregateFunction {

    // 输入数据的结构信息
    override def inputSchema: StructType = {
        new StructType().add("age", LongType)
    }

    // 缓冲区数据的结构信息
    override def bufferSchema: StructType = {
        new StructType().add("sum", LongType).add("count", LongType)
    }

    // 计算结果的类型
    override def dataType: DataType = DoubleType

    // 函数的稳定性
    override def deterministic: Boolean = true

    // 缓冲区数据初始化
    override def initialize(buffer: MutableAggregationBuffer): Unit = {
        buffer(0) = 0L
        buffer(1) = 0L
    }

    // 更新缓冲区数据（分区内计算）
    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
        buffer(0) = buffer.getLong(0) + input.getLong(0)
        buffer(1) = buffer.getLong(1) + 1L
    }

    // 合并缓冲区数据（分区间计算）
    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
        buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
        buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
    }

    // 计算
    override def evaluate(buffer: Row): Any = {
        buffer.getLong(0).toDouble / buffer.getLong(1)
    }
}
