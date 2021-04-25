package com.qiumingjie.rabbitmq.spring.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author QiuMingJie
 * @date 2020-04-09 17:13
 * @description
 */
@Component
public class Provider {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String queueName, String msg) {
        amqpTemplate.convertAndSend(queueName, msg);
        System.out.println("生产者传递队列" + queueName + msg);
    }


}
