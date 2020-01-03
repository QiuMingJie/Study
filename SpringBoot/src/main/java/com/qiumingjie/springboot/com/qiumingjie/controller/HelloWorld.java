package com.qiumingjie.springboot.com.qiumingjie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuMingJie
 * @date 2020-01-02 16:40
 * @Description
 */
@RestController
public class HelloWorld {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index() {
        return "Hello World";
    }
}
