package com.atguigu.bigdata.scala.chapter09


// 隐式转换
object Scala02_ClassType2  {
    // 隐式转换可以扩展类的功能
    def main(args: Array[String]): Unit = {

        implicit def transform(mysql:MySQL): NewMySQL = {
            new NewMySQL
        }

        val mysql = new MySQL
        mysql.insert()
        mysql.update()
    }


}
class MySQL {
    def insert(): Unit = {
        println("insert data....")
    }
}
class NewMySQL {
    def update(): Unit = {
        println("update data...")
    }
}
