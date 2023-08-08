package algorithm_imp.search_imp;

import java.util.ArrayList;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 8, 8, 8, 9, 12, 45};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 9));
        System.out.println(binarySearch2(arr, 0, arr.length - 1, 8));
        System.out.println(binarySearch(arr, 9));
        System.out.println(binarySearch2(arr, 8));
    }

    @SuppressWarnings("all")
    //返回单个数据 使用递归
    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (left > right || value < arr[0] || value > arr[arr.length - 1])
            return -1;
        int mid = (left + right) / 2;
        if (arr[mid] < value) {
            return binarySearch(arr, mid + 1, right, value);
        } else if (arr[mid] > value) {
            return binarySearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    @SuppressWarnings("all")
    //返回数据 使用递归
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int value) {
        if (left > right || value < arr[0] || value > arr[arr.length - 1])
            return null;
        int mid = (left + right) / 2;
        if (arr[mid] < value) {
            return binarySearch2(arr, mid + 1, right, value);
        } else if (arr[mid] > value) {
            return binarySearch2(arr, left, mid - 1, value);
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

    //返回一个数值 未使用递归
    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        if (value < arr[0] || value > arr[arr.length - 1])
            return -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //返回数组 未使用递归
    public static ArrayList<Integer> binarySearch2(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        if (value < arr[0] || value > arr[arr.length - 1])
            return null;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
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
        return null;
    }
}
