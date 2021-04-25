package com.atguigu.bigdata.scala.chapter02

object Scala02_Type {

    def main(args: Array[String]): Unit = {

        // 声明变量
        // 默认数值类型为int类型
        //val i : Byte = 10
        //val j : Short = 10
        //val k : Char = 'a'
        //val a : Int = 10
        //boolean

        //val d = 20.0f


        //val c : Char = 97
        //println(c)
        //val  c : Char = 'a' + 1

        //val b : Byte = 10;
        //val s : Short = 20;

        //val r = b + s

        //val i : Int = 10
        //val byte: Byte = i.toByte

        //val i1: Byte = 117 + 10

        val r = (10 * 3.5).toInt + (6 * 1.5).toInt

        println(r)

        var b : Byte  = 3
        //b = b + 4
        b = (b+4).toByte

        var c : Char  = 'a'
        var  i : Int = 5
        var d : Float = .314F
        var result : Double = c+i+d

        var b1 : Byte  = 5
        var s : Short  = 3
        //var t : Short = s + b1
        var t2 = s + b1
        t2



    }
}
