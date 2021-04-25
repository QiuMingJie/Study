package com.qiumingjie.rabbitmq.diy;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author QiuMingJie
 * @date 2020-04-09 14:21
 * @description 生产者
 */
public class Producer {
    private static final String EXCHANGE_NAME = "direct_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = MqConnection.newConnection();
        Channel channel = connection.createChannel();
        // 3.绑定的交换机 参数1交互机名称 参数2 exchange类型
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String routingKey = "info";
        String msg = "direct_exchange_msg" + routingKey;
        // 4.发送消息
        channel.basicPublish(EXCHANGE_NAME, routingKey, null, msg.getBytes());
        System.out.println("生产者发送msg：" + msg);
        // // 5.关闭通道、连接
        // channel.close();
        // connection.close();
        // 注意：如果消费没有绑定交换机和队列，则消息会丢失

    }
}
