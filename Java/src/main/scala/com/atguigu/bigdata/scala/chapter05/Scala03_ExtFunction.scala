package com.atguigu.bigdata.scala.chapter05

object Scala03_ExtFunction {

    def main(args: Array[String]): Unit = {

        // 可变参数,：在参数类型的后面使用星号声明
        def f1( name : String* ): Unit = {
            println(name)
        }

        //f1("a", "b", "c")
        //f1() // List()
        //f1("a") // WrappedArray(a)

        // 可变参数应该放置在参数列表的最后
        def f2( age:Int, name : String* ): Unit = {

        }

        // 参数默认值 : 声明参数时可直接设定默认值
        def f3( name : String, age : Int = 30 ): Unit = {
            println(s"$name, $age")
        }

        // 调用函数时，默认参数可以不用传
        //f3("zhangsan")
        // 调用函数时，如果传递了有默认值的参数，那么默认值会被覆盖
        //f3("lisi", 25)

        def f4( sex : String = "男", name : String ): Unit = {
            println(s"$name, $sex")
        }

        //f4("女", "wangwu")
        // 参数列表的传值，是从左到右

        // 带名参数：调用函数时，可以指明参数的名称
        f4(name="zhaoliu")

    }
}
