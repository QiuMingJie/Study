package com.qiumj.scala

/**
 * @author QiuMingJie
 * @date 2021/4/22 9:39
 * @description
 */
/**
 * scala 没有接口，只有特征，(一个意思)
 * scala 中没有实现，只有继承，继承特征
 * scala 有父类也有特征，先继承父类，混入特值
 */
object Interface {
  def main(args: Array[String]): Unit = {
    var user=new User12
    println(user)
    //动态混入
    val user1 =new User12 with Test
  }
}

//这里的接口可以写方法，有内容
trait Test{
  println("traint...")
  def test(): Unit ={
    println("312312")
  }

}
class User12 extends ParentUser12 with Test{
  println("child...")
}

class ParentUser12{
  println("parent...")
}