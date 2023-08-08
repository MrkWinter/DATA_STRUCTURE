package algorithm_imp.common_algo_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 2. 分治算法 (汉诺塔问题演示)
 */
public class DivideAndConquer {
    public static void main(String[] args) {
        hanNuoTa(5, 'A', 'B', 'C');
    }

    public static void hanNuoTa(int nums, char a, char b, char c) {
        //最小规模解决 //递归问题出路 //分的思想问题最小体解决
        if (nums == 1) {
            System.out.println(a + " 到 " + c);
            return;
        }
        //较大问题分解 //递归问题循环体 //治的思想将小问题归并到一起解决大问题
        hanNuoTa(nums - 1, a, c, b);
        System.out.println(a + " 到 " + c);
        hanNuoTa(nums - 1, b, a, c);
        //分(拆分问题)  治(治小问题) - (治大问题)
    }
}
