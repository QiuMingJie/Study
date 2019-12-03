package com.springStudy;

import com.entity.Student;
import com.entity.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;

/**
 * @author QiuMingJie
 * @date 2019-11-14 11:02
 * @Description
 */
@Controller
public class spring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        // ApplicationContext context = new FileSystemXmlApplicationContext("C:/Users/ZARA/workspace/HelloSpring/src/Beans.xml");
        Student student = (Student) context.getBean("student");
        DataSource dataSource = (DataSource)context.getBean("dataSource");
        Team team = (Team) context.getBean("team");
        String SQL = "select count(*) from Student";

        JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
        int rowCount = jdbcTemplateObject.queryForInt( SQL );
        System.out.println(rowCount);
        System.out.println(student.toString());
        System.out.println(team);
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap modelMap) {
        modelMap.addAttribute("hello spring mvc");
        return "hello";
    }


}
