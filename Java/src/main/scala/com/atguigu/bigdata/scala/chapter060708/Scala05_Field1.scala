package com.atguigu.bigdata.scala.chapter060708

import scala.beans.BeanProperty

// 面向对象 - 类的属性
object Scala05_Field1 {
    def main(args: Array[String]): Unit = {

        val user = new User05()

        // 方法类的属性，其实不是访问类的属性，而是调用了属性的相关方法（setter）
        user.username = "zhangsan"
        // 方法类的属性，其实不是访问类的属性，而是调用了属性的相关方法（getter）
        println(user.username)

        //user.age = 30
        println(user.age)

        //println(user.)
        //println(user.getTel)
    }
}
class User05 {
    // 声明类的属性，原则上是public权限，但是编译后，其实还是private属性，只不过同时生成公共的setter,getter方法
    var username : String = _

    // 如果类的属性使用val声明，那么编译后，属性声明会增加final关键字，而且不会提供setter方法
    val age : Int = 20

    // 如果类的属性使用private修饰，那么这个属性生成的setter,getter方法全都是私有的。
    private var email : String = _

    // 类的属性使用注解后，可以生成对应的set,get方法
    @BeanProperty var tel : String = _
}
