package com.mybatisStudy.entity;

import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2019-09-23 15:02
 * @Description
 */
public class Student implements Serializable {

    private String id;
    private String score;
    private String name;

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
}
