package com.springStudy;

import com.entity.Team;
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
        // ApplicationContext context = new FileSystemXmlApplicationContext("C:/Users/ZARA/workspace/HelloSpring/src/Beans.xml");
        //Student student = (Student) context.getBean("student");
        Team team=new Team();

        System.out.println(        team
                .toString());
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }
}
