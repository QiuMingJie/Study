package com.atguigu.bigdata.scala.chapter060708

import java.util.Date

import scala.beans.BeanProperty

// 面向对象 - 接口
object Scala12_Interface {
    def main(args: Array[String]): Unit = {

        // Scala中没有接口(interface)的概念, 有特征(特质:trait)的概念
        // Scala中无法实现特质，继承特质（特征）
        // Scala中特征，父类同时存在，那么需要先继承父类，然后混入(with)特质

        // 混入：扩展

        // OCP : Open Close

        // 特质中可以增加方法

        //val user = new User12
        //println(user)
        //user.test()

        // 动态混入：
        val user = new User12() with MyTrait
        user.test()

    }
}
trait MyTrait {
    def test(): Unit = {
        println("test...")
    }
}
class ParentUser12 {

}
//class User12 extends ParentUser12 with MyTrait {
class User12 extends ParentUser12 {

}



