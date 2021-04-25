package com.atguigu.bigdata.scala.chapter060708

import java.util.Date

import scala.beans.BeanProperty

// 面向对象 - 类型转换
object Scala15_Class4 {
    def main(args: Array[String]): Unit = {

        // User extends Person
        /*
        Person person = new User();
        User user = (User)person

        class User  {
            public boolean equals( Object obj ) {
                if ( obj instanceof User ) {

                    User user = (User)obj;
                    this.id == user.id

                } else {
                   return false
                }
            }
        }
        */

        //String.class
        val userClass: Class[User15] = classOf[User15]

        val user = new User15

        val bool: Boolean = user.isInstanceOf[User15]
        if ( bool ) {
            val user1: User15 = user.asInstanceOf[User15]
        }


    }
}
class User15 {

}

