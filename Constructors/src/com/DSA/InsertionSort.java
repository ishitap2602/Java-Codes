package com.DSA;

public class InsertionSort {
	public static void sortElements(int arr[]) {
		int n = arr.length;
		for(int i =0; i<n; i++) {
			int k = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>k) {
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1] = k;
			
		}
	}
	public static void displayData (int arr[]) {
		for(int dt:arr) {
			System.out.print(dt+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, -7, -2, 9, 1, 6, 3, 4, 8, 5}; // unsorted example
        // before sorting
        displayData(arr);
        sortElements(arr);
        // after sorting
        displayData(arr);
	}

}
