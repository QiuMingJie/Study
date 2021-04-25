package com.atguigu.bigdata.scala.chapter09

import com.atguigu.bigdata.scala.chapter09.chapter09.Scala05_ClassType5.Mysql05

package object chapter09 {

    // 隐式转换
    object Scala05_ClassType5 extends MyTrait05 {

        def main(args: Array[String]): Unit = {

            // 隐式转换规则会从当前作用域往上进行查找。
            val mysql = new Mysql05
            mysql.update()
        }

        class Mysql05 {
            def insert(): Unit = {
                println("insert data....")
            }
        }


    }

    trait MyTrait05 {


    }

    object MyTrait05 {
        // 隐式转换类
        implicit class NewMysql05(mysql : Mysql05) {
            def update(): Unit = {
                println("update data....")
            }
        }
    }
}


