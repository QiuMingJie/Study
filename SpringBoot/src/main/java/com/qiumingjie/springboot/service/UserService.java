package com.qiumingjie.springboot.service;

import com.qiumingjie.springboot.dao.UserRepository;
import com.qiumingjie.springboot.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author QiuMingJie
 * @date 2020-01-10 14:42
 * @Description
 */
@Service
public class UserService {
    @Resource
    UserRepository userRepository;

    public void test() {
        User byId = userRepository.findById(11L).orElse(null);
        System.out.println(byId);
        byId.setEmail("123");
        userRepository.save(byId);
        User user = userRepository.findById(11L).orElse(null);
        System.out.println(user);

    }

}
