package com.qiumingjie.sortArithmetic;

/**
 * @author QiuMingJie
 * @date 2020-01-05 15:02
 * @Description 十大排序算法
 * https://www.cnblogs.com/guoyaohua/p/8600214.html
 * 语句总的执行次数记为T[N]
 */
public class Sorts {
    private static int[] sortsInt = new int[]{0, 1, 5, 8, 456, 1849, 5, 1, 64, 56, 9841, 6, 16, 71, 56, 153, 5};

    public static void main(String[] args) {
        //  print(bubbleSort(sortsInt));
        selectionSort(new int[]{});
    }


    private static void print(int[] printInt) {
        if (printInt == null) {
            return;
        }
        for (int i = 0; i < printInt.length; i++) {
            System.out.print(printInt[i] + "   ");
        }
    }

    /**
     * 冒泡排序算法
     * 最佳情况：T(n) = O(n)  优化后的冒泡排序
     * 最差情况：T(n) = O(n*n)
     * 平均情况：T(n) = O(n*n)
     */
    public static int[] bubbleSort(int[] array) {
        boolean didSwap;
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            didSwap = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                return array;
            }
        }
        return array;
    }


    /**
     * 选择排序
     * 表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。
     * 最佳情况：T(n) = O(n2)
     * 最差情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    //找到最小的数，将最小数的索引保存
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * 最佳情况：T(n) = O(n)
     * 最坏情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }



}
