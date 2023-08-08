package algorithm_imp.search_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 4. 斐波那契查找
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 9, 12, 45};
        System.out.println(fibonacciSearch(arr,45));
    }

    public static int fibonacciSearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int k = 0;
        int mid = 0;
        int f[] = getFibonacciArr(20);
        while (right >= f[k]) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = temp[right];
        }
        while (left <= right) {
            mid = left + f[k - 1] - 1; //f[k] 是数组长度 f[k-1]-1 是前半 f[k-2]-1 是后半
            if (temp[mid] > value) {
                right = mid - 1;
                k--; //f[k-1] - 1  可分为 f[k-2]-1 和 f[k-3]-1
                //下次循环就找到了前半的黄金分割位置
            } else if (temp[mid] < value) {
                left = mid + 1;
                k -= 2; //f[k-2] -1 可分为f[k-3]-1 和 f[k-4]-1
            } else {
                return mid < arr.length ? mid : arr.length;
            }
        }
        return -1;
    }

    //得到斐波那契数列
    public static int[] getFibonacciArr(int n) {
        int[] fArr = new int[n];
        fArr[0] = fArr[1] = 1;
        for (int i = 2; i < fArr.length; i++) {
            fArr[i] = fArr[i - 1] + fArr[i - 2];
        }
        return fArr;
    }
}
