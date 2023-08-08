package algorithm_imp.sorting_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 7. 基数排序(桶排序)
 */
/*
 * 1. 稳定性排序
 * */
public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {2, 4, 1, 7, 0, 9, 3};
        int[] arr = {10, 100, 10, 100};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        //容量桶
        int[][] buckets = new int[10][arr.length];
        //计数桶量数组
        int[] capacity = new int[10];
        //统计排序轮数
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxNum < arr[i])
                maxNum = arr[i];
        }
        int round = maxNum + "".length();
        for (int i = 0; i < round; i++) {
            //放入桶
            for (int j = 0; j < arr.length; j++) {
                int no = arr[j] / (int) Math.pow(10, i) % 10;
                buckets[no][capacity[no]++] = arr[j];
            }
            //取回放入数组
            int index = 0;
            for (int j = 0; j < capacity.length; j++) {
                if (capacity[j] != 0) {
                    for (int k = 0; k < capacity[j]; k++) {
                        arr[index++] = buckets[j][k];
                    }
                    capacity[j] = 0;
                }
            }
        }
    }
}
