package com.atguigu.bigdata.scala.chapter12

object Scala01_Match1 {

    def main(args: Array[String]): Unit = {

        // scala中的模式匹配可以匹配具体的值

        /*
        val oper = '#'
        val n1 = 20
        val n2 = 10
        var res = 0
        oper match {
            case '+' => res = n1 + n2
            case '-' => res = n1 - n2
            case '*' => res = n1 * n2
            case '/' => res = n1 / n2
            //case _ => println("oper error")
        }
        println("res=" + res)
        */

        /*
        for (ch <- "+-3!") {
            var sign = 0
            var digit = 0
            ch match {
                case '+' => sign = 1
                case '-' => sign = -1
                case _ if ch.toString.equals("3") => digit = 3
                case _ => sign = 2
            }
            println(ch + " " + sign + " " + digit)
        }
        */

        /*
        for (ch <- "+-3!") {
            var sign = 0
            var digit = 0
            ch match {
                case '+' => sign = 1
                case '-' => sign = -1
                case _  => digit = 3
                case _  => sign = 2
            }
            println(ch + " " + sign + " " + digit)
        }
        */

        /*
        for (ch <- "+-3!") {
            var sign = 0
            var digit = 0
            ch match {

                case '+' => sign = 1
                case '-' => sign = -1
                case _  => digit = 3 //默认
            }
            println(ch + " " + sign + " " + digit)
        }
        */

        val ch = 'V'
        ch match {
            case '+' => println("ok~")
            case mychar => println("ok~" + mychar)
            case _ => println ("ok~~")
        }






    }
}
