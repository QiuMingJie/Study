package com.atguigu.bigdata.scala.chapter13

object Scala01_Function {

    def main(args: Array[String]): Unit = {

        //
        val list = List(1, 2, 3, 4, "abc")

        /*
        val list1: List[Any] = list.map {
            x => {
                if (x.isInstanceOf[Int]) {
                    x.asInstanceOf[Int] + 1
                } else {
                    x
                }
            }
        }
        */

        val list1: List[Any] = list.map {
            x => {
                x match {
                    case i: Int => i + 1
                    case _ => x
                }
            }
        }

        val list2: List[Any] = list1.filter(x=>x.isInstanceOf[Int])
        println(list2)


    }
}
