package com.qiumingjie.design.mode;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author QiuMingJie
 * @date 2020-06-14 16:58
 * @description 设计模式--工厂模式
 */

public class FactoryMode {
    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar a = Calendar.getInstance();
        a.setTimeInMillis(1592012783252L);
        System.out.println(dateFormat.format(a.getTime()));

    }
}
