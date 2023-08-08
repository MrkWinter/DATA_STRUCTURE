package algorithm_imp.common_algo_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 3. 动态规划算法 (以01背包问题为例)
 */
public class DynamicProgram {

    public static void main(String[] args) {
        int[] value = {1200, 2000, 3000, 4500, 6000};
        int[] weight = {1, 2, 3, 5, 6};
        int[][] knapsack = knapsack(value, weight, 10);
        for (int i = 0; i < knapsack.length; i++) {
            System.out.println(Arrays.toString(knapsack[i]));
        }
    }

    /*solution数组是指在有前i个商品 j容量下每个商品最多只能有一个的价值最优解
     * value数组是指第i个商品的价值
     * weight数组是指第i个商品的重量*/
    public static int[][] knapsack(int[] value, int[] weight, int bagMax) {
        if (value == null || value.length == 0 || weight == null || weight.length == 0 ||
                value.length != weight.length || bagMax <= 0)
            return null;
        int[][] solution = new int[value.length][bagMax];
        String[][] method = new String[value.length][bagMax];
        for (int i = 0; i < method.length; i++) {
            Arrays.fill(method[i], "");
        }
        //依次配置最优解
        for (int i = 1; i < solution.length; i++) {
            for (int j = 1; j < solution[0].length; j++) {
                if (j < weight[i - 1]) { //不能放下当前商品 寻找前i-1个商品 j容量下的最优解
                    solution[i][j] = solution[i - 1][j];
                    method[i][j] = method[i - 1][j];
                } else { //当前商品能放
                    //如果当前商品i放入的价值 + 剩余容量存放前i-1个商品的价值最优解 的值 大于不放入当前商品j容量下前i-1件商品的最优解
                    if (value[i - 1] + solution[i - 1][j - weight[i - 1]] > solution[i - 1][j]) {
                        solution[i][j] = value[i - 1] + solution[i - 1][j - weight[i - 1]];
                        method[i][j] = method[i - 1][j - weight[i - 1]] + " " + i;
                    } else {
                        solution[i][j] = solution[i - 1][j];
                        method[i][j] = method[i - 1][j];
                    }
                }
            }
        }
        for (int i = 0; i < method.length; i++) {
            System.out.println(Arrays.toString(method[i]));
        }
        return solution;
    }
}
