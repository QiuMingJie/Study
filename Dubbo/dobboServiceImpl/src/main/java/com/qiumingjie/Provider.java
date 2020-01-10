package com.qiumingjie;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author QiuMingJie
 * @date 2019-12-31 11:42
 * @Description
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();
        System.out.println("dubbo服务提供端已启动....");
        Scanner sc = new Scanner(System.in);
        System.out.println("ScannerTest, Please Enter Name:");
        String name = sc.nextLine();  //读取字符串型输入
        System.out.println("ScannerTest, Please Enter Age:");
        int age = sc.nextInt();    //读取整型输入
        System.out.println("ScannerTest, Please Enter Salary:");
        float salary = sc.nextFloat(); //读取float型输入
        System.out.println("Your Information is as below:");
        System.out.println("Name:" + name +"\n" + "Age:"+age + "\n"+"Salary:"+salary);
    }
}
