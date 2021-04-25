package com.atguigu.bigdata.scala.chapter060708

package test {

    class TestUser {

    }

    package test0 {

        import com.atguigu.bigdata.scala.chapter060708.test1.TestUser2

        class TestUser1 {
            def main(args: Array[String]): Unit = {
                val testUser = new TestUser

                val testUser2 = new TestUser2
            }
        }
    }


}
package test1 {
    class TestUser2 {

    }
}
// scala中，包也是对象, 需要采用特殊的方式声明

package object test {
    private val name : String = "zhangsan"

    def test(): Unit = {

    }
}

package test2 {


    // 面向对象 - 包
    object Scala02_Package {

        def main(args: Array[String]): Unit = {
            // 包的作用
            // 1. 分门别类的管理
            // 2. 区分相同名称的类：java.util.Date, java.sql.Date
            // 3. 访问作用域

            // Scala给package语法赋予了更多的内容
            // 1. 类所声明的包和它所在的包可以不一致
            // 2. 包的声明方式可以更多样化
            //    2.1 可以同时声明多个package关键字:父子包
            //    2.2 声明包的同时增加作用域（大括号）
            //    2.3 使用父包中的类时，是不需要导入的。其他包中的类，还是需要导入的。
            println("yyyyy")
        }
    }

}
