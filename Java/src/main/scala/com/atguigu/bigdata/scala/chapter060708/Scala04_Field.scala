package com.atguigu.bigdata.scala.chapter060708

// 面向对象 - 类的属性
object Scala04_Field {
    def main(args: Array[String]): Unit = {

        // Scala给类的属性进行默认初始化，可以采用下划线声明
        // 类的属性修饰符：
        // java  ==> public, private, protected, (default)
        // scala ==> (public), private, protected, private[包名]
        // scala对于protected访问权限有限制，只能同类和子类访问，其他地方无法访问
        // scala中如果想要使用包访问权限，需要采用特殊方式 : private[包名]

        val user04 = new User04
        user04.address = "xxxxx"
    }
}
class User04 {
    var name : String = _
    private var age : Int = _
    protected var sex : String = _
    private[bigdata] var address :String = _
}
/*
class ChildUser04 extends User04 {

    def test(): Unit = {
        sex
    }
}
*/