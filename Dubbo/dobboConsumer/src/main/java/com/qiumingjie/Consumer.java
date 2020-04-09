package com.qiumingjie;

import com.qiumingjie.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author QiuMingJie
 * @date 2020-01-02 10:27
 * @Description
 */
public class Consumer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        System.out.println("dubbo服务消费端已启动...");
        DemoService demoService = (DemoService) context.getBean("demoService");// 获取远程服务代理
        String hello = demoService.sayHello("world");//执行远程方法
        System.out.println(hello);//显示调用结果
        System.in.read(); // 按任意键退出
    }
}
