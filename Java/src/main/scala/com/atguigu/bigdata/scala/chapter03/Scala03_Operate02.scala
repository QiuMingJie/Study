package com.atguigu.bigdata.scala.chapter03

object Scala03_Operate02 {

    def main(args: Array[String]): Unit = {

        val flg : Boolean = false

        // int i = flg?1:0
        // scala中所有的运算都会有结果，所有的表达式也有结果
        var i : Int = if (flg) 1 else 0

        /*
        if ( flg ) {
            i = 1
        } else {
            i = 0
        }
        */


        // if表达式的结果取决于满足条件的最后一行逻辑代码
        val j = if (flg) {
            "abc"
        } else {
            0
            10
        }

        println(j)
    }
}
