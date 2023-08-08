package algorithm_imp.search_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 1. 线性查找
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 45, 83, 8, 47, 90};
        System.out.println(linearSearch(arr, 8));

    }

    public static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==value)
                return i;
        }
        return -1;
    }
}
