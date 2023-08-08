package algorithm_imp.sorting_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 1. 冒泡排序
 */
/*
* 1. 冒泡排序时间复杂度为 o(n^2)
* */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 7, 2, 8, 2, 8, 3, 1, 9, 22};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] ints = new int[80000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int) (Math.random()* 100);
        }
        long t1 = System.currentTimeMillis();
        bubbleSort(ints);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }

    public static void bubbleSort(int[] arr) {
        boolean flag = true;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                //如果本趟没有交换 则数组有序 退出
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if (flag)
                return;
        }
    }
}
