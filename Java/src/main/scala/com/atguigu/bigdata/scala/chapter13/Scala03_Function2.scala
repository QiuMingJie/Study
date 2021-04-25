package com.atguigu.bigdata.scala.chapter13

import scala.util.control.Breaks

object Scala03_Function2 {

    def main(args: Array[String]): Unit = {

       // 控制抽象
        def test( f: =>Unit ): Unit = {
            f
        }

        test{
            val i = 10
            println(i)
        }

//        Breaks.breakable{
//            for () {
//                Breaks.break()
//            }
//        }


    }
}
