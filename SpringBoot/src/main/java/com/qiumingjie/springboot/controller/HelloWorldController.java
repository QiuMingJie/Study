package com.qiumingjie.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuMingJie
 * @date 2020-01-02 16:40
 * @Description
 */
@RestController
public class HelloWorldController {
    /**
     *    获取properties中的内容
     */
    @Value("${com.neo.title}")
    private String title;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index() {
        return "Hello World"+title;
    }
}
