package com.atguigu.bigdata.java;

import java.util.Random;

public class TestRandom {

    public static void main(String[] args) {

        Random r = new Random(100);
        for(int i = 0; i < 10; i++) {
            System.out.println("i = " + r.nextInt());
        }
        System.out.println("*************************************");
        r = new Random(10);
        for(int i = 0; i < 10; i++) {
            System.out.println("i = " + r.nextInt());
        }

        Math.random();// new Random().nextDouble();
    }


}
