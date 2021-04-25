package com.atguigu.bigdata.scala.chapter05

object Scala02_Function1 {

    def main(args: Array[String]): Unit = {

        // 无参，无返回值
        def f1(): Unit = {
            println("f1...")
        }

        //f1()

        // 无参，有返回值
        def f2() : String = {
            return "Scala"
        }

        //println("Hello" + f2())

        // 有参，无返回值
        def f3( s : String ): Unit = {
            println("s = " + s)
        }

        //f3("Scala")

        // 有参，有返回值
        def f4(s: String): String = {
            return "Hello " + s
        }

        //println(f4("Scala"))

        // 参数列表为多个
        def f5( name : String, age : Int ): Unit = {
            println(s"name = ${name.trim}, age = $age")
        }

        f5( "zhangsan", 30 )
    }
}
