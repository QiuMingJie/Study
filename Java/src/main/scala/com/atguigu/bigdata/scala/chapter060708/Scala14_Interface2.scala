package com.atguigu.bigdata.scala.chapter060708

import java.util.Date

import scala.beans.BeanProperty

// 面向对象 - 接口
object Scala14_Interface2 {
    def main(args: Array[String]): Unit = {

        val mysql = new Mysql();
        mysql.insert()
    }
}
trait Operate {
   // println("operate...")
    def insert(): Unit = {
        println("插入数据....")
    }
}
// 特质可以继承的，多个特质，采用with连接
// java中所有的接口在scala都是特质
trait DB extends Operate with Serializable {
    //println("db...")
    override def insert(): Unit = {
        print("向数据库中")
        super.insert()
    }
}

trait File extends Operate {
    //println("file...")
    override def insert(): Unit = {
        print("向日志文件中")
        // 特质中的super不是表示父特质，表示上一个特质,如果没有上一个特质，那么会查找父特质
        // 可以指定需要调用特质的方法
        super[Operate].insert()
    }
}

// 混入多特质的场合，那么会从左到右开始初始化
// 混入多特质的场合，那么会从右到左开始执行
class Mysql extends File with DB {
    //println("mysql...")
}


