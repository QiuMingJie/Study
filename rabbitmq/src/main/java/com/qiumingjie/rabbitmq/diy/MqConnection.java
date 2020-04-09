package com.qiumingjie.rabbitmq.diy;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author QiuMingJie
 * @date 2020-04-09 14:17
 * @description 手写的连接rabbitmq连接工厂
 */
public class MqConnection {
    public static Connection newConnection() throws IOException, TimeoutException {
        //定义连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("qiumingjie");
        connectionFactory.setPassword("123456");
        return connectionFactory.newConnection();
    }
}
