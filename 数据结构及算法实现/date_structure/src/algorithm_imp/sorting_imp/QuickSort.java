package algorithm_imp.sorting_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 5. 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 4, 0};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        quickSort2(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int lIndex = left;
        int rIndex = right;
        int middleNum = arr[lIndex];
        while (lIndex < rIndex) {
            while (arr[rIndex] >= middleNum && lIndex < rIndex) {
                rIndex--;
            }
            arr[lIndex] = arr[rIndex];
            arr[rIndex] = middleNum;
            while (arr[lIndex] <= middleNum && lIndex < rIndex) {
                lIndex++;
            }
            arr[rIndex] = arr[lIndex];
            arr[lIndex] = middleNum;
        }
        if (left < lIndex - 1)
            quickSort(arr, left, lIndex - 1);
        if (rIndex + 1 < right)
            quickSort(arr, rIndex + 1, right);
    }

    public static void quickSort2(int[] arr, int left, int right) {
        int lIndex = left;
        int rIndex = right;
        int middleNum = arr[(left + right) / 2];
        int temp = 0;
        while (lIndex < rIndex) {
            //从左边找到一个大的 右边找到一个小的
            while (arr[lIndex] < middleNum ) {
                lIndex++;
            }
            while (arr[rIndex] > middleNum ) {
                rIndex--;
            }
            //交换
            if (lIndex < rIndex) {
                temp = arr[lIndex];
                arr[lIndex] = arr[rIndex];
                arr[rIndex] = temp;
            }
            //处理异常问题
            if (arr[lIndex] == middleNum) {
                rIndex--;
            }
            if (arr[rIndex] == middleNum) {
                lIndex++;
            }
            if(lIndex == rIndex) {
                lIndex++;
                rIndex--;
            }
            if (left < lIndex)
                quickSort(arr, left, lIndex);
            if (rIndex < right)
                quickSort(arr, rIndex , right);
        }
    }
}
