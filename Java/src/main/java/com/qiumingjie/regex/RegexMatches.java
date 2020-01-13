package com.qiumingjie.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author QiuMingJie
 * @date 2019-12-09 14:15
 * @Description 正则表达式
 */

public class RegexMatches {
    String doublePattern = "^\\d+(\\.\\d+)?";

    public static void main(String args[]) {
        /**
         *  ^表示字符串的开始
         *  $表示结束符
         *  \b 匹配一个单词边界，即字与空格间的位置。
         *  \B 非单词边界匹配。
         *  \d+ 匹配一个或多个数字
         *
         *  [0-9]表示匹配都是数字，也可以写[2-9]
         *  [a-z]表示匹配都是单词
         *  [a-z0-9_-]这样子写也可以，表示匹配0-9,a-z,-_这些字符
         *
         *  {a,b},a,b为数字，表示最少匹配a次,最多匹配b次
         *  {a} 匹配a次
         *  {a,}匹配a次到无数次
         *
         *  . 匹配除了换行之外的任意字符
         *
         *  + 表示前面的字符匹配一次或者多次
         *  * 表示前面的字符匹配任意次
         *  ？表示前面的字符匹配0次或者1次
         *
         *  ()标记一个子表达式的开始到结束
         *  |两项中的一项
         *  \正则的转义字符
         */
        String str = "cat cat cat cat fdd";
        String pattern = ".*cat.*";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(str);
        //matches要求全部匹配
        System.out.println(m.matches());
        //只要匹配到就行了
        System.out.println(m.lookingAt());
        int count = 0;
        while(m.find()) {
            count++;
            System.out.println("匹配了 "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
        /*
        if (m.find( )) {

        } else {
            System.out.println("NO MATCH");
        }*/
    }

}
