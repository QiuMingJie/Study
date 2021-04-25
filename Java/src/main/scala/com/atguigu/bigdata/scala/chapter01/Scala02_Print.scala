package com.atguigu.bigdata.scala.chapter01

/**
  * Scala的打印
  */
object Scala02_Print {

    def main(args: Array[String]): Unit = {

        // 声明变量
        var name : String = "zhangsan"
        var age : Int = 20
        var email : String = "zhangsan@163.com"

        //println("用户名称 = " + name + ", 年龄 = " + age + ", 邮箱 = " + email)

        // 插值字符串
        // 字符串前使用s后，可以在字符串的里面使用插值语法 $变量
        //println(s"用户名称 = $name, 年龄 = $age, 邮箱 = $email \n")
        // 字符串前使用f后，可以在字符串的里面插值语法进行格式化
        //println(f"用户名称 = $name, 年龄 = $age%.2f, 邮箱 = $email \n")
        // 字符串前使用raw后，可以不对字符串的转义内容进行还转义
        //println(raw"用户名称 = $name, 年龄 = $age, 邮箱 = $email \n")
        //println(s"用户名称 = $name, 年龄 = $age, 邮箱 = $email \n")
        // 使用三个引号声明字符串，可以按照指定的格式输出

        /*

         */
        println(s"""
            用户名称 = $name
            年龄 = $age
            邮箱 = $email""")
    }
}
