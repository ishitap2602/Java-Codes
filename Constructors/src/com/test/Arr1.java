package com.test;

public class Arr1 {

	public static void main(Strings1[] args) {
		// TODO Auto-generated method stub
		int arr [] [] = new int [3][3];
		arr [0][0] = 102;
		
		int[][] arr1 = {{101,102,103}, {201,202,203}, {301,302,303}};
				System.out.println(arr[0][0]);
		for (int i = 0; i<arr1.length; i++) {
			for(int j = 0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
