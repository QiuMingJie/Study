package com.qiumingjie.springboot.controller;

import com.qiumingjie.springboot.dao.UserRepository;
import com.qiumingjie.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserService userService;

    UserRepository userRepository;

    /**
     *    获取properties中的内容
     */
    @Value("${com.neo.title}")
    private String title;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index() {
        userService.test();
        return "Hello World"+title;
    }



}
