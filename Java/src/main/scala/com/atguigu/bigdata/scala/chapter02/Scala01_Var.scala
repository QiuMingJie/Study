package com.atguigu.bigdata.scala.chapter02

// Scala的变量
class Scala01_Var {
    val username = "zhangsan"
}
object Scala01_Var {

    def main(args: Array[String]): Unit = {

        // 声明变量
        // java
        // 类型 变量名 = 变量值
        // Scala : 声明变量需要使用关键字
        // var|val : 声明变量
        // Scala中使用val声明的变量的值无法改变
        // var 变量名:类型 = 变量值
        //var name : String = "zhangsan"

        //name = "lisi"

        // scala中声明变量一定要初始化
        //val age : Int = 20

        // scala语言：至简原则( 能省则省 )
        //val password : String = "123123"
        // 当scala能自行推断语法时，对应的语法内容可以省略
        //val password = "123123"

        //println(name + "," + age + "," + password)

        var name = "123"
        //val age = 20
        //age = 30


        //val age : Int = null
    }

    def test(): Nothing = {
        throw  new RuntimeException
    }
}
