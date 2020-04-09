package com.qiumingjie.springboot;

import com.qiumingjie.springboot.dao.UserRepository;
import com.qiumingjie.springboot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author QiuMingJie
 * @date 2020-01-03 11:30
 * @Description
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        userRepository.deleteAll();
        userRepository.save(new User("aa1", "aa", "aa@126.com", "aa123456", formattedDate));
        userRepository.save(new User("bb2", "bb", "bb@126.com", "bb123456", formattedDate));
        userRepository.save(new User("cc3", "cc", "cc@126.com", "cc123456", formattedDate));

//        Assert.assertEquals(3, userRepository.findAll().size());
//        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb2", "cc@126.com").getNickName());
//        Assert.assertEquals("bb", userRepository.findByUserNameAndEmail("bb2", "cc@126.com").getNickName());
        System.out.println(userRepository.findByUserNameOrEmail("bb2", "cc@126.com").toString());
        System.out.println(userRepository.findByUserNameAndEmail("bb2", "bb@126.com").toString());
        System.out.println(userRepository.findByIdBetween(1L, 10000000L).toString());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }

}
