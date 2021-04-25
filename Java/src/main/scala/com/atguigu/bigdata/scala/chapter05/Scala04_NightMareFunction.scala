package com.atguigu.bigdata.scala.chapter05

object Scala04_NightMareFunction {

    def main(args: Array[String]): Unit = {

        // 至简原则
        def f1( s : String ): String = {
            return "Hello " + s
        }

        // return关键字可以省略
        def f2( s : String ): String = {
            "Hello " + s
        }

        //println(f2("Scala"))

        // 如果能够推断出返回值类型，返回值可以省略
        def f3( s : String ) = {
            "Hello " + s
        }

        //println(f3("Scala"))

        // 函数体如果只有一行逻辑代码，那么函数的大括号可以省略
        def f4(s:String) = "Hello " + s

        //println(f4("Scala"))

        // 无参函数,调用的时候，小括号可以省略
        // 无参函数,声明的时候，小括号可以省略
        def f5() = "Hello Scala"
        def f6 = "Hello Scala"
        //println(f5)
        //println(f6)

        // 函数如果没有使用小括号声明参数列表，那么调用时不能使用小括号
        //println(f6)

        // 函数如果显示声明为Unit,那么即使函数体中的有return语法也不起作用
        def f7(): Unit = {
            return "Scala"
        }

        //f7()

        def f8() = {
            "Scala"
        }

        //println(f8)

        // 如果想要省略Unit，并且函数不需要自动推断，那么等号可以省略
        // 将这样的函数称之为 过程
        def f9() {
            "Scala"
        }

        println(f9)

        //匿名函数
        //()->{println("XXXXX")}
        //()=>{println("XXXXX")}
        val f = (s:String)=>{println("s = " + s)}
        //val f1 = (s:String)=>{s}

        // 如果将匿名函数赋值给变量，那么会自动产生函数类型
        // (String) => Unit
        //f1

        f("Scala")
    }
}
