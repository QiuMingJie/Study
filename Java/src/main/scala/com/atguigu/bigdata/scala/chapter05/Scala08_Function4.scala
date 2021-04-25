package com.atguigu.bigdata.scala.chapter05

object Scala08_Function4 {

    def main(args: Array[String]): Unit = {

        def test1( x : Double ) : (Double)=>Double = {

            def test2( y : Double ) : Double = {
                x * x * y
            }

            test2
        }


        println(test1(2.0)(3.0))
    }
}
