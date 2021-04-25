package com.atguigu.bigdata.scala.chapter05

object Scala01_Function {

    def main(args: Array[String]): Unit = {

        // 函数式编程 & 面向对象编程

        // 函数式编程 : 解决问题的步骤，每一个步骤其实就是逻辑封装，这个封装称之为函数,类似于java中的静态方法（工具类中的静态方法）

        // 面向对象: 分解对象,建立对象和对象的关系

        // 函数式编程中最重要的是：函数，万物皆函数,方法也是函数

        // 声明在类中的函数，称之为方法


        /*
            java method

            public static void test( String s ) {
                System.out.println(s);
            }

            new Object().test("123");
            Object.test("123")

         */

        /*
            scala声明函数，必须使用关键字def声明
            scala函数默认访问权限就是public,所以无需声明
            scala没有静态的语法，通过伴生对象模拟静态语法
            scala是一个非常灵活的语言：任何的语法中可以声明任何的语法
         */
        // val 变量名：变量类型 = 变量值
        // def 函数名(参数列表):返回值类型 = {函数体}
        //     参数列表：变量名：类型, 变量名1：类型1

        // 函数声明
        def test( s : String ):Unit = {
            println(s)
        }

        // 函数没有重载的概念，只要函数名一样，那么报错
        //def test(s : String, i : Int): Unit = {
        //    println(s)
        //}

        // 函数调用
        // 函数名（参数）
        test("Hello Scala")

    }
}
