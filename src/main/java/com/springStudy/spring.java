package com.springStudy;

import com.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author QiuMingJie
 * @date 2019-11-14 11:02
 * @Description
 */
public class spring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.getName().toString());

    }


}
