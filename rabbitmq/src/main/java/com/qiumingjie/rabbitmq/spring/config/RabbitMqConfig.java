package com.qiumingjie.rabbitmq.spring.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author QiuMingJie
 * @date 2020-04-09 17:02
 * @description
 */
@Configuration
public class RabbitMqConfig {

    public final static String MES_QUEUE = "mes_queue";

    public final static String EMAIL_QUEUE = "email_queue";

    public final static String EXCHANGE_NAME = "exchange_test";

    @Bean
    Queue mesQueue() {
        return new Queue(MES_QUEUE);
    }

    @Bean
    Queue emailQueue() {
        return new Queue(EMAIL_QUEUE);
    }

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding mesBinding(Queue mesQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(mesQueue).to(exchange);
    }

    @Bean
    Binding emailBinding(Queue emailQueue, FanoutExchange exchange) {
        return BindingBuilder.bind(emailQueue).to(exchange);
    }
}
