package com.java;

/**
 * @author QiuMingJie
 * @date 2019-12-10 10:09
 * @Description
 */
public class JavaStudy {
    private void care() {
        int count = 2;
        System.out.println("注意switch中切记要加break");
        switch (count) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
        }

        /**
         * 使用逻辑运算符时，我们会遇到“短路”的现象：一旦能够确定整个表达式的值，就不会计算余下的部分了，当然，这个功能点其实是非常有用的，但对于初学者来说，可能会感觉比较惊讶，使用不当就会产生“坑爹”后果。比如下面的代码：
         */
        int num = 1;
        System.out.println(false && ((num++) == 1));
        System.out.println(num);

        //把[-128, 127]之间的值缓存起做为缓冲池
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);
        System.out.println(a.equals(b));

        int i = 1;
        while (i < 4) {
            System.out.println(i++);
        }
        //会陷入死循环
//        while (i < 4) ;
//        {
//            System.out.println(i++);
//        }


        int c = 100;
        c =+ 2;  //注意，加号在后面
        System.out.println(c);
        //unicode解码发生在代码编译之前
        // \u000d System.out.println("Hello World!");

    }


    public static void main(String[] args) {
        JavaStudy javaStudy = new JavaStudy();
        javaStudy.care();
    }
}
