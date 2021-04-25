package com.atguigu.bigdata.scala.chapter05

object Scala05_HellFunction {

    def main(args: Array[String]): Unit = {

        // 函数式编程中所有的操作全是基于函数的，所以函数可以作为参数，也可以作为返回值
        def f1(s:String) = {
            println("f1..." + s)
        }

        // 将函数作为参数传递给另外一个函数
        def f2( f:(String) => Unit ) = {
            f("Scala")
        }

        // 调用函数
        //f2(f1)

        def f3() = {
            println("f3...")
        }

        // 将函数作为返回值,而不是调用，那么需要使用特殊符号：下划线
        def f4() = {
            f3 _
        }

        //f4()()

        def f5 () = {

            def f55( i: Int ): Unit = {
                println("i = " + i)
            }

            f55 _

        }

        //f5()(10)

        // 函数柯里化（Curring）
        def f66( j : Int, i: Int ): Unit = {
            println(i * j)
        }
        def f6(j:Int)(i:Int): Unit = {
            println(i * j)
        }

        //f6()(10)
        // 函数闭包
        // 函数将外部使用的变量包含到函数的内部来使用，称之为闭包，可以改变变量的生命周期
        def f7(i : Int) = {
            def f77( j : Int ): Unit = {
                println(i * j)
            }

            f77 _
        }
        //f7(10)(20)

        // 匿名函数
        def f8( f:(Int)=>Unit ): Unit = {
            f(10)
        }

        def f88(): Unit = {
            println("f88.....")
        }

        def f888(): Unit = {
            println("xxxxxxx")
        }

        //val f = (x:Int)=>{println(x)}

        //f(10)

        //f8((x)=>{println(x)})
        // scala中如果函数的参数只使用了一次，可以省略，采用特殊符号（下划线）代替
        //f8(println(_))
        //f8(println)

        // 10, 20,

        def f9( i : Int ) = {

            def f99 ( j : Int ) = {

                def f999 ( f : (Int, Int)=>Int ) = {
                    f( i, j )
                }

                f999 _
            }

            f99 _

        }

       // val result: Int = f9(10)(20)( (x,y)=>{x-y} )
        val result: Int = f9(10)(20)(_+_)

        println(result)

    }
}
