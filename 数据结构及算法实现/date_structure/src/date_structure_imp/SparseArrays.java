package date_structure_imp;

import java.io.*;

/**
 * @author MrkWinter
 * @version 1.0
 * 1 稀疏数组的压缩
 */
public class SparseArrays {
    public static void main(String[] args) throws IOException {
//创建稀疏数组
        int[][] sparseArr = new int[10][12];
        sparseArr[3][4] = 5;
        sparseArr[6][7] = 19;
        sparseArr[9][0] = 12;
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[0].length; j++) {
                System.out.print(sparseArr[i][j] + "\t");
            }
            System.out.println();
        }
//稀疏数组的压缩
        int count = 0;
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr.length; j++) {
                if (sparseArr[i][j] != 0) {
                    count++;
                }
            }
        }
        int[][] arr = new int[count + 1][3];
        arr[0][0] = sparseArr.length;
        arr[0][1] = sparseArr[0].length;
        arr[0][2] = count;
        int temp = 1;
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[0].length; j++) {
                if (sparseArr[i][j] != 0) {
                    arr[temp][0] = i;
                    arr[temp][1] = j;
                    arr[temp][2] = sparseArr[i][j];
                    temp++;
                }
            }
        }
//稀疏数组的存储
        BufferedWriter bw = new BufferedWriter(new FileWriter("arr.txt"));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }
        bw.close();

//稀疏数组的读取
        BufferedReader br = new BufferedReader(new FileReader("arr.txt"));
        String str = null;
        int[][] arr1 = null;
        int count1 = 0;
        while ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            if (arr1 == null) {
                arr1 = new int[Integer.parseInt(s[2]) + 1][3];
            }
            for (int j = 0; j < arr1[0].length; j++) {
                arr1[count1][j] = Integer.parseInt(s[j]);
            }
            count1++;
        }
        br.close();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.print(arr1[i][j] +"\t");
            }
            System.out.println();
        }
//稀疏数组的恢复
        int[][] sparseArr1 = new int[arr1[0][0]][arr1[0][1]];
        for (int i = 1; i < arr1.length; i++) {
            sparseArr1[arr1[i][0]][arr1[i][1]] = arr1[i][2];
        }
        for (int i = 0; i < sparseArr1.length; i++) {
            for (int j = 0; j < sparseArr1[0].length; j++) {
                System.out.print(sparseArr1[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

