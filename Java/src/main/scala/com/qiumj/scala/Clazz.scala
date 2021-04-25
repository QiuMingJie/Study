package com.qiumj.scala

/**
 * @author QiuMingJie
 * @date 2021/4/21 17:36
 * @description
 */
object Clazz {

}

abstract class User{
  //属性，编译后只有抽象方法
  val name:String
  def test
}

//子类想要重写父类方法，必须加override修饰符
class ClildUser08 extends User{
  override def test: Unit ={
    println("4444")
  }

   val name: String = ""
}

//namex和成员变量一致
class test1(var namex:String ){

}