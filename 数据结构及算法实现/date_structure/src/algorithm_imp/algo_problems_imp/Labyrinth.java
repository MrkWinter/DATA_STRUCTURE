package algorithm_imp.algo_problems_imp;

import java.util.Arrays;

/**
 * @author MrkWinter
 * @version 1.0
 * 4 迷宫问题
 */
public class Labyrinth {
    private static int count = 0;
    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 6, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        }; //迷宫
        showAnswer(arr, 1, 1);
//        showAnswer2(arr, 1, 1);
    }

    public static void showAnswer(int arr[][], int i, int j) {
        if (arr[i][j] == 6) {
            showArr(arr);
            System.out.println("----------共"+ count + "步---------------");
            return;
        }
        arr[i][j] = 2;
        if (arr[i][j + 1] == 0 || arr[i][j + 1] == 6) {
            count++;
            showAnswer(arr, i, j + 1);
        }
        if (arr[i][j - 1] == 0 || arr[i][j - 1] == 6) {
            count++;
            showAnswer(arr, i, j - 1);
        }
        if (arr[i + 1][j] == 0 || arr[i + 1][j] == 6) {
            count++;
            showAnswer(arr, i + 1, j);
        }
        if (arr[i - 1][j] == 0 || arr[i - 1][j] == 6) {
            count++;
            showAnswer(arr, i - 1, j);
        }
        arr[i][j] = 0;
        count--;
    }

    public static void showArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean showAnswer2(int[][] arr, int i, int j) {
        if (arr[i][j] == 6) {
            showArr(arr);
            return true;
        } else if (arr[i][j] == 0) {
            arr[i][j] = 2;
            if (showAnswer2(arr, i, j + 1)) {
                return true;
            } else if (showAnswer2(arr, i, j - 1)) {
                return true;
            } else if (showAnswer2(arr, i + 1, j)) {
                return true;
            } else if (showAnswer2(arr, i - 1, j)) {
                return true;
            } else {
                arr[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }
}
