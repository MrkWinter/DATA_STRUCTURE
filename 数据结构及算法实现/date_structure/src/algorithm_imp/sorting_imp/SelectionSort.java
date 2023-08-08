package algorithm_imp.sorting_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 2. 选择排序
 */
/*
* 1. 要把复杂问题简单化
* 2. 选择排序比冒泡排序快一点
* 3. 时间复杂度为o(n^2)
* */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 90, 3, 9, 7};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        int minNums = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minNums = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //如果有找到最小值 再进行交换操作
                if (arr[j] < minNums) {
                    minNums = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = minNums;
            }
        }
    }
}
