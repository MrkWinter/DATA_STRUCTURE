package date_structure_imp;

import java.io.FileWriter;

// 1ϡ�������ѹ��
public class SparseArray {
	public static void main(String[] args) {
//����ϡ������
		int[][] sparseArr = new int[10][12];
		sparseArr[3][4] = 5;
		sparseArr[6][7] = 19;
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr[0].length; j++) {
				System.out.print(sparseArr[i][j] + "\t");
			}
			System.out.println();
		}
//ϡ�������ѹ��
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
//ϡ������Ĵ洢
		FileWriter fw = FileWriter("arr.txt");
	}
}
