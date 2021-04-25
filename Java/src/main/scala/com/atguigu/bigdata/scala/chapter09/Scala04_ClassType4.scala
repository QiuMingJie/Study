package com.atguigu.bigdata.scala.chapter09

// 隐式转换
object Scala04_ClassType4 {

    def main(args: Array[String]): Unit = {

        val mysql = new Mysql04
        mysql.update()
    }

    class Mysql04 {
        def insert(): Unit = {
            println("insert data....")
        }
    }

    // 隐式转换类
    implicit class NewMysql04(mysql : Mysql04) {
        def update(): Unit = {
            println("update data....")
        }
    }
}
