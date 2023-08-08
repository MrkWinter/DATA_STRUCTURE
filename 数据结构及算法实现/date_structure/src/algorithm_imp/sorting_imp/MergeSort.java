package algorithm_imp.sorting_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 6. 归并排序
 */
/*归并排序
*  1. 先通过递归将数组分成小部分
*  2. 小部分数组排序后归并一个大数组
*  3. 大数组排序后归并
*  4. 重复2,3 递归完成排序
* */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {34, 74, 32, 98, 45, 17};
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        //将arr中对应的数按规律移动到temp数组中对应的位置
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //将temp数组拷贝到原数组应该的位置
        for (int k = left,l = 0; k <= right; k++,l++) {
            arr[k] = temp[l];
        }
    }
}
