package algorithm_imp.sorting_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 4. 希尔排序
 */
public class ShallSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 9, 4, 8, 0};
//        shallSort(arr);
//        System.out.println(Arrays.toString(arr));
        shallSort2(arr);
        System.out.println(Arrays.toString(arr));


    }

    //交换法希尔排序 (使用交换插入排序效率很低 不能使用)
    public static void shallSort(int[] arr) {
        //不断分组
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //不断找到第一组的第一个下标 第二个下标...直到最后一个下标(奇数情况存在一组多一个)
            for (int i = 0; i < arr.length - gap; i++) {
                //将所有组找到下标起前面位置保证有序 这里用了交换插入的方法 和冒泡不一样 而是将后面的数字放在前面有序的的位置 保证前面有序
                for (int j = i; j >= 0; j -= gap) {
                    //如果不合适就一直交换直到合适
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //移动法希尔排序 (使用了传统的插入排序)
    public static void shallSort2(int[] arr) {
        int insertNum = 0;
        int insertIndex = 0;
        //分组
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //取组头
            for (int i = 0; i < arr.length - gap; i++) {
                //每组使用插入排序达到有序
                insertNum = arr[i + gap];
                insertIndex = i + gap;
                //得到插入数字
                 while (insertIndex >= gap && arr[insertIndex - gap] > insertNum) {
                    arr[insertIndex] = arr[insertIndex - gap];
                     insertIndex -= gap;
                }
                 if(insertIndex !=i+gap)
                     arr[insertIndex] = insertNum;
            }
        }
    }
}
