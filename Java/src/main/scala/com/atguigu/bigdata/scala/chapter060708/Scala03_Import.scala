package com.atguigu.bigdata.scala.chapter060708

import java.util.{HashMap=>JavaHashMap}


// 面向对象 - 导类
object Scala03_Import {
    def main(args: Array[String]): Unit = {

        // import
        // java
        // 声明的位置需要指定的
        // 一般用于导入类或静态的方法,如果为了方便，可以将某一个包中的所有类导入，使用星号
        // scala对import进行功能的补充
        // 1. import 关键字可以声明在任意的位置
        // 2. 可以用于导包 :
        //    import java.util
        // 3. 可以用于隐藏导入的类 ：
        //    import java.sql.{Date=>_}
        // 4. 可以使用花括号将同一个包中的类同时声明
        //    import java.util.{List, HashMap}
        // 5. 可以使用下划线表示一个包中的所有的类
        //    import java.util._
        // 6. scala默认情况下，有些包中内容可以直接使用：
        //    java.lang, scala
        // 7. 如果导包时，类比较多，容易造成混乱，所以可以导包的绝对路径
        //    import _root_.java.util.HashMap
        // 8. scala可以在导类的时候，给类起别名 :
        //    import java.util.{HashMap=>JavaHashMap}
        new JavaHashMap()


    }
}
package javay {
    package utily {
        class HashMapX {

        }
        class Test {
            def main(args: Array[String]): Unit = {
                //new _root_.java.util.HashMap()
            }
        }
    }
}
