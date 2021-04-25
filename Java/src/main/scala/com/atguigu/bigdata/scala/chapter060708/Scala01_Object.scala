package com.atguigu.bigdata.scala.chapter060708

import java.util.List

// 面向对象
object Scala01_Object {

    def main(args: Array[String]): Unit = {

        /*   Java 面向对象编程方式：

        package

        import : 导类

        class User extends Parent implements Interface {

           public String name;

           public void loing() {

           }

        }

        User user = new User();
        user.name = "zhangsan"
        user.login()



         */

        /*   Scala 面向对象编程方式

             1. 声明包的方式相同
             2. 导类方式也是一样的
             3. 声明类基本相同
             4. 声明类的属性基本相同： val 属性名：属性类型 = 属性值
             5. 声明类的方法基本相同： def 函数名（参数列表）:函数返回值类型 = {函数体}
             6. 对象创建方式以及调用方式基本相同
         */
        val user01 = new User01()
        user01.username = "lisi"
        user01.login()


    }
}
class User01 {

    var username : String = "zhangsan"

    def login(): Boolean = {
        true
    }
}
