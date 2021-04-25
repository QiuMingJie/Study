package com.atguigu.bigdata.scala.chapter01

/**
  * Scala的第一个例子
  *
  * java 代码：
  *
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
  */
object Scala01_Demo {
    print("231")
    /*

    public  : scala中的访问权限默认是公共的，所以不需要声明
    static  : scala是一个完全面向对象的语言，所以没有静态语法，也就没有static
              当前的main方法是在编译时，由Scala通过特殊对象（伴生对象）进行调用的。
    伴生对象 : 伴随着类所产生的对象,使用object关键字声明的类，称之为伴生对象
              伴生对象基本的使用方式其实就是为了替代静态语法

    main方法参数 : scala中方法参数的声明方式和java不一样。将参数名称放置在前，类型放置在后，中间采用冒号隔开

         java : String name
         scala : name : String

         中文：我 爱 xxxxxxx  你
         英文：i love you who


    void : 在java中一个方法如果没有返回值，采用void关键字,在scala中，采用对象来声明,采用Unit类型的对象

     */
    def main(args: Array[String]): Unit = {
        // Predef$.MODULE$.println("xxxxxx");
        // scala可以将某些语法内容进行简化，开发起来更加方便
        println("Hello Scala");println("Hello World")
    }
}
class Scala01_Demo{
    print("3211111")
}
