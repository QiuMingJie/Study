package com.atguigu.bigdata.scala.chapter05

object Scala07_Function3 {

    def main(args: Array[String]): Unit = {

        // 阶乘：一个大于1的数的阶乘等于这个数乘以这个数减一的阶乘
        // 5! = 5 * 4! = 5 * 4 * 3! = 5 * 4 * 3 * 2! = 5 * 4 * 3 * 2 * 1
        // 1,3,5,7,9,11 ==>
        // 123 + 3443 + 4343 + 43434 + 3242
        // 递归： 1. 数据之间有规律
        //       2. 函数调用自身
        //       3. 函数应该有跳出递归的逻辑
        //       4. 明确返回值类型

        def test( i : Int ) : Int = {
            if ( i == 1 ) {
                1
            } else {
                i * test(i-1)
            }
        }

        println(test(5))
    }
}
