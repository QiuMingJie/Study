package com.atguigu.bigdata.scala.chapter10

object Scala01_JavaList {

    def main(args: Array[String]): Unit = {

        // Java集合：List, Set , Map, 数组

        // 数组：定长(不可变), 确定类型
        // List, Set, Map：变长（可变）,不需要确定类型

        // List : 有序，可重复的

        /*
            User user = new User();

            List list = new ArrayList();
            list.add(user)
            list.add(user)

            // clone浅复制
            ArrayList list = new ArrayList();
            ArrayList list1 = list.clone();

         */

        // Set  : 无序，不可重复

        /*

           Set set = new HashSet() ==> HashMap

           set.add("a") ==> hashMap ==> key
           set.add("a")

         */

        // Map  : 无序，K-V对，K不能重复，V可以重复

        /*

            Map map = new HashMap()
            map.put(k, v)
            map.get(k)

         */

    }
}
