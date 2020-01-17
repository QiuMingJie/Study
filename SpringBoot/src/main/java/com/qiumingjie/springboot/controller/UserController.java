package com.qiumingjie.springboot.controller;

import com.qiumingjie.springboot.dao.UserRepository;
import com.qiumingjie.springboot.entity.User;
import com.qiumingjie.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;


/**
 * @author QiuMingJie
 * @date 2020-01-07 19:06
 * @Description
 */
@RestController()
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService userService;
    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/find")
    public Page<User> findAll(){
        int page=1,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        return userRepository.findAll(pageable);
    }


    @RequestMapping("/test")
    /**
     *    原生sql
     */
    public void find() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(false);   //start transaction，开启事务
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);//避免脏读
        Statement st = null;
//3.获取用于向数据库发送sql语句的statement
        st = conn.createStatement();
//4.向数据库发sql
        String sql = "select * from user where id =7";
        ResultSet resultSet = st.executeQuery(sql);
        resultSet.afterLast();
        resultSet.previous();
        System.out.println(resultSet.getObject("email").toString());
        String update = "UPDATE  user SET email='1' WHERE (id='7')";
        st.execute(update);

        ResultSet resultSet2 = st.executeQuery(sql);
        resultSet2.afterLast();
        resultSet2.previous();
        System.out.println(resultSet2.getObject("email").toString());
        conn.commit();//提交
    }


    @RequestMapping("/testJpa")
    public Object testJpa() {
        Sort sort = new Sort(Sort.Direction.valueOf("DESC") ,"id");
        Pageable pageable = new PageRequest(1, 1);
        return userRepository.findByPassWordAndEmail("bb123456","bb@126.com");
    }




}
