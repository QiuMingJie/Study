package com.qiumingjie.springboot.controller;

import com.qiumingjie.springboot.entity.User;
import com.qiumingjie.springboot.service.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * @author QiuMingJie
 * @date 2020-01-07 19:06
 * @Description
 */
public class UserController {
    private UserRepository userRepository;

    /**
     * 分页查询
     * @return
     */
    public Page<User> findAll(){
        int page=1,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return userRepository.findALL(pageable);
    }



}
