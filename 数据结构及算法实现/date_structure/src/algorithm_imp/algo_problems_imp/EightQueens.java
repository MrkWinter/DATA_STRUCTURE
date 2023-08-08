package algorithm_imp.algo_problems_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 5 八皇后问题
 */
/*
* 递归问题求解
* 1. 递归结束条件
* 2. 递归下去条件
* 3. 回溯后影响的消除
* */
public class EightQueens {
    private static int count;
    public static void main(String[] args) {
//        int[][] arr = new int[8][8];
//        showAnswer(arr, 0);

        int[] arr2 = new int[8];
        showAnswer2(arr2,0);
    }

    public static void showAnswer(int[][] arr, int row) {
        //结束的条件
        if (row == 8) {
            showBoard(arr);
            System.out.println("------第"+ ++count + "种解法------");
            return;
        }
        for (int i = 0; i < arr[0].length; i++) {
            arr[row][i] = 1;
            if (checkBoard(arr, row, i)) {
                showAnswer(arr, row + 1);
                //回溯后将该列置为0 接着下一行
                arr[row][i] = 0;
            } else {
                arr[row][i] = 0;
            }
            //这里不用置为0 因为下次会直接覆盖
        }
        //一行结束 回溯函数
    }

    public static void showAnswer2(int[] arr, int k) {
        if (k == 8) {
            showBoard2(arr);
            System.out.println("------第"+ ++count + "种解法------");
            return;
        }
        for (int i = 1; i <= 8; i++) {
            arr[k] = i;
            if(checkBoard2(arr,k)) {
                showAnswer2(arr,k+1);
                arr[k] = 0;
            } else {
                arr[k] = 0;
            }
        }
    }

    //检测该数组该行上的该列值是否合适
    public static boolean checkBoard(int[][] arr, int row, int k) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    if (j == k || Math.abs(row - i) == Math.abs(k - j))
                        return false;
                }
            }
        }
        return true;
    }

    public static void showBoard(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean checkBoard2(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            if(arr[i] == arr[k] ||Math.abs(k-i) == Math.abs(arr[k]-arr[i])) {
                return false;
            }
        }
        return true;
    }
    public static void showBoard2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
