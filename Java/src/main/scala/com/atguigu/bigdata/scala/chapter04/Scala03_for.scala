package com.atguigu.bigdata.scala.chapter04

object Scala03_for {

    def main(args: Array[String]): Unit = {

        // 循环控制
        /* Java:
          步长
          for ( int i = 0; i < list.size(); i=i+2 ) {
          if ( i % 2 == 0 ) {

          } else {

          }
              sout(i)
          }

          for ( Object obj : List ) {
              sout(obj.name)
          }


          for ( int i = 1; i <= 3; i++ ) {
              int j = 4 - i
              sout(j)
          }

         */

        // scala
        /*
        for ( i <- 1 to 5 ) {
          // println("i = " + i)
        }

        // 循环守卫
        for ( i <- 0 until 5 if i % 2 == 0 ) {
            //println("i = " + i)
        }

        // 循环变量
        for{i <- 1 to 3; j = 4 - i} {
            //println(i + "=" + j)
        }

        // 嵌套循环
        // 一个for循环打印杨辉三角
        for{
            i <- 1 to 3
            j <- 1 to 3} {
            //println(" i =" + i + " j = " + j)
        }
        */

        // 改变步长
        //1 + 5
        // 1 to 5 表示范围，也可以采用对象的方式创建范围
        //val inclusive: Range.Inclusive = 1 to 5
        //inclusive // 1.to(5)

        /*
        val r = Range(1, 5, 2)

        for ( i <- r ) {
            println("i = " + i)
        }
        */

        /*
        for {
            i <- Range(1, 18, 2)
            j = (18 - i)/2
        } {
            println(" "*j + "*"*i + " " * j)
        }
        */

        // for循环的返回值默认没有 Unit

        val r = for ( i <- 1 to 5 ) yield i * 2

        println("result = " + r)

    }
}
