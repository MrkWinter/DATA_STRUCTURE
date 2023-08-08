package algorithm_imp.search_imp;

import java.util.ArrayList;

/**
 * @author MrkWinter
 * @version 1.0
 * 3. 插值查找
 *    简单来说就是在二分查找的基础上添加一个自适应定位查找算法
 *    更快的在关键字分布较均匀的查询表中找到对应的数据
 */
/*
* 1. 对于数据量较大 关键字分布较均匀的查询表来说 用插值查找较快
*    关键字分布不均匀的情况下 插值查找不一定比折半查找要好
* */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 8, 8, 8, 9, 12, 45};
        System.out.println(interpolationSearch(arr, 0, arr.length - 1, 8));
    }

    public static ArrayList<Integer> interpolationSearch(int[] arr, int left, int right, int value) {
        if (left > right || value < arr[0] || value > arr[arr.length - 1])
            return null;
        int mid = left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
        //自适应查找
        if (arr[mid] < value) {
            return interpolationSearch(arr, mid + 1, right, value);
        } else if (arr[mid] > value) {
            return interpolationSearch(arr, left, mid - 1, value);
        } else {
            ArrayList<Integer> integers = new ArrayList<>();
            int i = mid;
            while (i >= 0 && arr[i] == value) {
                i--;
            }
            for (i = i + 1; i < arr.length && arr[i] == value; i++) {
                integers.add(i);
            }
            return integers;
        }
    }
}
