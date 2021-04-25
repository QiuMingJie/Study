package com.qiumingjie.rabbitmq.spring.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuMingJie
 * @date 2020-04-09 17:21
 * @description
 */
@RestController
public class RabbitController {

    @Autowired
    Provider provider;

    @RequestMapping("/sendFanout/{queueName}")
    public String sendFanout(@PathVariable("queueName") String queueName) {
        provider.send(queueName, "213");
        return "success";
    }

}
