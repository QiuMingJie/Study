package com.qiumingjie.springboot.service;

import com.qiumingjie.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author QiuMingJie
 * @date 2020-01-03 11:28
 * @Description
 */
public interface  UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}
