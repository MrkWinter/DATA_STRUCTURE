package algorithm_imp.common_algo_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 1. 二分查找算法 (非递归)
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 3, 6, 2, 8, 4}, 3));
    }

    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (arr[mid] > value) {
                right = mid - 1;
            } else if (arr[mid] < value) {
                left = mid + 1;
            } else {
                return mid;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }
}
