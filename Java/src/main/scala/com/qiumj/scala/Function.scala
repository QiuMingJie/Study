package com.qiumj.scala

/**
 * @author QiuMingJie
 * @date 2021/4/20 11:44
 * @description
 */
object Function {


  //函数式编程
  /**
   * java
   * public static void method(){
   *    System.out.println("123");
   * }
   *
   * scala默认就是public,有点类似static
   * 函数里面可以有函数
   */
  def method(s :String): String = {
    return s"${s.trim}"
  }

  //可变参数，也是得在最后面，和java ...一样
  def extParam(s:String*):String ={
    println(s)
    return s.toString();
  }


  //参数默认值，默认从左到右，可以用带名参数
  def defaultPara(param:String ="你好"):String={
    return param;
  }

  //------------------------至简原则------------------------------
  //return关键字可以省略
  def noReturn(param:String ="你好"):String={
     param;
  }

  //如果能推断出返回值类型，返回值可以省略
  def noReturnNoReturnDec(param:String ="你好")={
    param;
  }

  //如果能推断出返回值类型，返回值可以省略，如果只有一行，花括号可以省略
  def noReturnNoReturnDecNoKuoHao(param:String ="你好")= param;

  //如果能推断出返回值类型，返回值可以省略，如果只有一行，花括号可以省略，假如只有一个参数，可以省略括号，调用时候只有一个参数可以省略括号

  //函数如果没有小括号声明，调用时候不可以用小括号访问

  //明确知道没返回值时候，可以省略=
  def a(){
    "a"
  }
  //这种情况返回a
  def ab(){
    return "a"
  }

  //匿名函数声明,匿名函数复制给变量
  val f= (s:String )=>{println("abc")}

  //将函数作为参数传递给另外一个函数
  def f1(f:(String)=>Unit):String={
    f("aaaa")
    return "213"
  }

  //将函数作为返回值，注意后面要加_不然就是执行函数
  def f2()={
    f1(f)
  }
//  def f3()={
//    f1(f) _
//  }

  //函数科里化（curring），下面两种写法一个意思
  def f6={
    def f5={
      "nihao"
    }
    f5 _
  }
  def f7()()={
      "nihao"
  }
  //函数闭包，将外部使用的变量包含到函数内使用，改变变量的生命周期
  def f8(i:Int)={
    def f5(j:Int)={
      //此处i还在
      i*j
    }
    f5 _
  }

  //多重嵌套
  def f9(i:Integer )={
    def f10(j:Integer)={
      def f11(f:(Integer,Integer )=>Integer)={
        f(i,j)
      }
      f11 _
    }
    f10 _
  }


}
