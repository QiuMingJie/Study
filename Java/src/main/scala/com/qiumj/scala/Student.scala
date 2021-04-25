//package com.qiumj.scala
//
///**
// * @author QiuMingJie
// * @date 2021/4/21 15:07
// * @description
// */
//object Student {
//
//  def main(args: Array[String]): Unit = {
//    val a=User1
//    val ab=User1("123")
//    val Student1=new Student2("321")
//    val Student2=new Student2
//  }
//
//}
//
//class Student1{
//  //private String name;
//  private  var name:String =_
//  protected var age:Integer=_
//  //public
//  var clazz:String =_
//  //包访问权限
//  private[scala]  var name1:String =_
//}
//
//
//class User(){
//
//}
//
//object User1{
//  //应用方法，创建对象不适用new的方式时，scala会自动出
//  //返回对象可以是其他类型
//  //一般情况下用于构建半生对象
//  def apply(): User = new User()
//  def apply(a:String): User = new User()
//
//}
//
////scala构造方法有两种，主构造&辅构造
////可以直接通过主或者辅创建对象
////如果通过辅构造方法，必须直接或间接调用主构造方法
////scala是完全面向函数的编程语言！！！！ 主构造方法私有化，加private
//class Student2 private (s:String){
//    println(s)
//  def this(){
//    this("辅助构造方法")
//  }
//}