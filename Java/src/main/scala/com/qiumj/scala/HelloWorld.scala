package com.qiumj.scala

import java.io

import scala.util.control.Breaks

/**
 * @author QiuMingJie
 * @date 2021/4/16 14:34
 * @description
 */
object HelloWorld {


  def main(args: Array[String]): Unit = {
    //    break()
    studyFor()
    Function.method("12")
    println(Function.defaultPara())
    println(Function.defaultPara(param = "嘿嘿"))
    //匿名函数
    Function.f1(x=>println(x))
    //只有一个参数时候可以写成下划线
    Function.f1(println(_))
    //只有一个参数时候可以省略
    Function.f1(println)
    val integer:Int = Function.f9(9)(3)((x, y) => (x + y))
    val integer1:Int = Function.f9(9)(3)(_ + _)

    //惰性加载
    val a:Int = Function.f9(9)(3)(_ + _)
    println("-------")
    println(a)

    try{
      val a= 1/0
    } catch{
      case e:Exception=>println("异常")
      case e:ArithmeticException=>println("异常1")
    }finally {
      println("213123")
    }


  }

  //break方法，完全面向对象，底层用异常
  def break(): Unit = {
    var i = 0;
    Breaks.breakable {
      while (i < 10) {
        if (i == 5) {
          Breaks.break()
        }
        i = i + 1
        println(i)
      }
    }
  }

  //遍历
  def studyFor(): Unit = {
    println("-----------to---------")
    for (i <- 1 to (5)) {
      println(i)
    }

    println("-----------until---------")
    for (i <- 1 until (5)) {
      println(i)
    }


    println("-----------守卫if---------")
    for (i <- 1 until 5 if i % 2 == 0) {
      println(i)
    }

    println("---------循环变量-----------")
    for (i <- 1 until 5; j = 4 - i) {
      println(j)
    }

    println("---------两层循环-----------")
    for (i <- 1 until 5; j <- 1 until 5) {
      println(j)
    }

    println("---------改变步长-----------")
    for (elem <- Range.apply(0, 5, 2)) {
      println(elem)
    }
  }

}
