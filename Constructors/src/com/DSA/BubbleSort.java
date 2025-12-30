package com.DSA;

public class BubbleSort {
	public static void sortElements(int arr[]) {
		int n = arr.length;
		int t = 0;
		for (int i = 0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				if(arr[j] > arr[j+1]) {
					t=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=t;
					
				}
			}
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
		int arr[] = {10, -7, 2, 9, 1, 6, 3, 4, 8, 5}; // unsorted example
        // before sorting
        displayData(arr);
        sortElements(arr);
        // after sorting
        displayData(arr);
    }
	}


