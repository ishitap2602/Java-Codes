package com.DSA;

public class LinearSearch {
	public static int searchElement(int arr[], int target) {
		for (int i = 0; i<arr.length; i++) {
			if(arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {50, 10, 70, 30, 80, 90, 20};
		int target = 90;
		int index = searchElement(arr, target);
		if(index != -1) {
			System.out.println("The target element is: "+arr[index]);
		}
		else {
			System.out.println("The target value not found in array");
		}
	}

}
