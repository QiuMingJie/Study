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
//        selectionSort(new int[]{});
        print(shellSort(sortsInt));
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
     * 1、冒泡排序算法
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
     * 2、选择排序
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
     * 3、插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * 最佳情况：T(n) = O(n)
     * 最坏情况：T(n) = O(n2)
     * 平均情况：T(n) = O(n2)
     *
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

    /**
     * 4、我们来看下希尔排序的基本步骤，在此我们选择增量gap=length/2，缩小增量继续以gap = gap/2的方式，这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2...1}，称为增量序列。希尔排序的增量序列的选择与证明是个数学难题，我们选择的这个增量序列是比较常用的，也是希尔建议的增量，称为希尔增量，但其实这个增量序列不是最优的。此处我们做示例使用希尔增量。
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * <p>
     * 最佳情况：T(n) = O(nlog2 n)
     * 最坏情况：T(n) = O(nlog2 n)
     * 平均情况：T(n) =O(nlog2n)
     *
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }


}
