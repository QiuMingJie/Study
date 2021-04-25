package com.atguigu.bigdata.scala.chapter060708

import java.util.Date

import scala.beans.BeanProperty

// 面向对象 - 类的构造方法
object Scala07_Method1 {
    def main(args: Array[String]): Unit = {

        // java 构造方法
        /*

           class User {

               public User() {
                   this("xxxx")
               }

               public User( String name ) {

               }

           }


         */

        // scala
        //val user = new User07("zhangsan")

        //val user = new User07("xxxxxx")

    }
}

// Scala中的构造方法分为2种类型： 主构造方法 & 辅助构造方法
// Scala可以直接通过主构造方法创建对象，也可以通过辅助构造方法创建对象
// 如果通过辅助构造方法创建对象，那么一定要直接或间接调用主构造方法

// 如果scala中的类没有显示的声明构造方法，等同于自动包含无参构造方法，可以通过new直接调用

// scala是完全面向函数的编程语言，所以类其实也是函数,函数就有参数列表
// 在类的后面的小括号所代表的方法其实就是主构造方法

// 主构造方法如果想要私有化，那么需要在参数列表前增加private修饰符
class User07 private( s : String ) {
    // 类体 & 构造函数体
    println(s)

    // 辅助构造方法
    // 构造方法使用this关键字

    // 如果构造方法掉用了其他的构造方法，那么必须提前声明
    def this( s : String, age : Int ) {
        this(s)
    }

    def this() {
        this("xxxxx", 20)
    }


}