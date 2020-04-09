package com.qiumingjie.springboot.controller;

import com.qiumingjie.springboot.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author QiuMingJie
 * @date 2020-01-06 16:57
 * @Description 查询数据库，运用了spring data jpa 和缓存
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 开启redis缓存，会缓存return的类
     *
     * @return
     */
    @RequestMapping("/redis")
    @Cacheable(value = "user13-key")
    public User getUser() {
        User user = new User("aaddd@126.com", "aa", "aa123456", "aa", "123");
        User user1 = new User("a1addd@126.com", "aa", "aa123456", "aa", "123");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user1;
    }


    /**
     * @param session
     * @return
     */
    @RequestMapping("/session")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
