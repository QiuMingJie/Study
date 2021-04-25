package com.atguigu.bigdata.scala.chapter060708

import java.util.Date

import scala.beans.BeanProperty

// 面向对象 - 接口
object Scala13_Interface1 {
    def main(args: Array[String]): Unit = {

        // 在执行过程中，如果存在相同的多个特质，那么只会执行一遍
        new User13
    }
}
trait MyTrait13 {
    println("trait...")
}
//class ParentUser13 extends MyTrait13 {
class ParentUser13 {
    println("parent...")
}
class User13 extends ParentUser13 with MyTrait13 {
    println("child...")
}



