package com.qiumingjie.sys.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author QiuMingJie
 * @date 2020-01-10 18:09
 * @Description 获取系统输入的三种方法 https://blog.csdn.net/idomyway/article/details/82748000
 */
public class SystemIn {

    public static void main(String[] args) {
//        sysInOut();
//        sysStream();
        scanner();
    }

    /**
     * 方法一，根据系统输入输出流
     * 缺点一: 该方法能获取从键盘输入的字符，但只能针对一个字符的获取
     * 缺点二: 获取的只是char类型的。如果想获得int,float等类型的输入,比较麻烦。
     */
    public static void sysInOut() {
        try{
            System.out.print("Enter a Char:");
            char i = (char)System.in.read();
            System.out.println("Yout Enter Char is:" + i);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *InputStreamReader和BufferedReader方法
     * 优点: 可以获取键盘输入的字符串
     *  缺点: 如何要获取的是int,float等类型的仍然需要转换
     */
    public static void sysStream(){
        System.out.println("ReadTest, Please Enter Data:");
        //new构造InputStreamReader对象
        InputStreamReader is = new InputStreamReader(System.in);
        //拿构造的方法传到BufferedReader中，此时获取到的就是整个缓存流
        BufferedReader br = new BufferedReader(is);
        try{ //该方法中有个IOExcepiton需要捕获
            String name = br.readLine();
            System.out.println("ReadTest Output:" + name);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *优点一: 可以获取键盘输入的字符串
     * 优点二: 有现成的获取int,float等类型数据，非常强大，也非常方便；
     */
    public static void scanner(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ScannerTest, Please Enter Name:");
        String name = sc.nextLine();
        System.out.println("ScannerTest, Please Enter Age:");
        int age = sc.nextInt();
        System.out.println("ScannerTest, Please Enter Salary:");
        float salary = sc.nextFloat();
        System.out.println("Your Information is as below:");
        System.out.println("Name:" + name +"\n" + "Age:"+age + "\n"+"Salary:"+salary);
    }

}
