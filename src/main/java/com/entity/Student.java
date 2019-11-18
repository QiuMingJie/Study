package com.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2019-09-23 15:02
 * @Description
 */
public class Student implements Serializable ,InitializingBean,DisposableBean {

    private String id;
    private String score;
    private String name="111";


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", score='" + score + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    @Required
    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化bean");
    }

    public void init() {
        System.out.println("init初始化bean");
    }

    public void destroy() throws Exception {
        System.out.println("销毁bean");
    }

    public void des() {
        System.out.println("des销毁bean");
    }
}
