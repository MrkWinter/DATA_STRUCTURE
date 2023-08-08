package algorithm_imp.sorting_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 9, 4, 0, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        //先构建一个大顶堆

///**
//        int temp;
//        for (int i = arr.length - 1; i > 0; i--) {
//            for (int j = (i + 1) / 2 - 1; j >= 0; j--) {
//                adjust(arr, j, i + 1);
//            }
//            temp = arr[i];
//            arr[i] = arr[0];
//            arr[0] = temp;
//        }
// 实际上不需要每次都进行循环堆排序 只需循环一次堆排序 下次直接以根节点进行排序 就能找到最大值
// */

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            //对每个非叶子结点进行堆排序 从左到右 从上到下
            //此次循环后整个数组已经成为了大顶堆
            //根结点改变 下次只需对根结点进行堆排序就能再次形成一个大顶堆
            adjust(arr, i, arr.length);
        }
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];//将较大元素放入最后
            arr[0] = temp;
            adjust(arr, 0, i); //i为堆排序元素个数
        }
        //将大顶堆的根(最大元素和顶堆的最后一个元素交换)
        //递归构建大顶堆 和最后元素交换
    }

    //该函数负责将较大值放到i(非叶子结点处)---较大值上升函数
    public static void adjust(int[] arr, int i, int length) {
        //length指定为需要进行堆排序的元素个数
        int temp = arr[i]; //保存i的值 若i值不符合大堆树的结构 将arr[i]方到较合适的位置
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) { //循环向左
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++; //原本是与左子树比较看是否交换的 若右子树大 则与柚子树比较
            }
            if (arr[j] > temp) {
                //如果子树有较大值 则与非叶子结点交换
                arr[i] = arr[j];
                i = j;
                //下次循环消除交换产生的影响
            } else {
                break;
                //这里能break的原因是该函数只负责一次将该i结点和叶子结点的较大值放到i处 并消除改变造成的影响
                //从最下方的非叶子结点开始从左到右从上到下多次调用该函数才能实现大顶堆的形参 该函数类似于一趟冒泡排序
            }
        }
        arr[i] = temp;//不需要在for循环里面交换 只需要依次与temp 也就是最开始的非叶子结点的值进行比较
        //将该值放入合适的位置即可

    }
}
