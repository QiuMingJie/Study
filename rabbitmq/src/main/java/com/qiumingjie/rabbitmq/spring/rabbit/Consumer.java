package com.qiumingjie.rabbitmq.spring.rabbit;

import com.qiumingjie.rabbitmq.spring.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author QiuMingJie
 * @date 2020-04-09 17:13
 * @description
 */
@Component
@RabbitListener(queues = RabbitMqConfig.EMAIL_QUEUE)
public class Consumer {

    @RabbitHandler()
    public void process(String msg) {
        System.out.println("消费者消费" + msg);
    }


}
