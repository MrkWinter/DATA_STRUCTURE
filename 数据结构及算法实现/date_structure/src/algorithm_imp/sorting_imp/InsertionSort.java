package algorithm_imp.sorting_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 3. 插入排序
 * 时间复杂度 o(n^2)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 9, 4, 6, 7, 34, 17, 479};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        //n个数据需要插入n-1次 从第二个数开始
        int insertIndex = 0;
        int insertNum = 0;
        for (int i = 1; i < arr.length; i++) {
            insertIndex = i;
            insertNum = arr[i];
            while (insertIndex >= 1 && arr[insertIndex - 1] > insertNum) {
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex--;
            }
            if (insertIndex != i)
                arr[insertIndex] = insertNum;
        }
    }
}
