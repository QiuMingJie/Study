package com.qiumingjie;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

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
        System.in.read(); // 按任意键退出
    }
}
