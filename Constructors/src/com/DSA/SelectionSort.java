
package com.DSA;

public class SelectionSort {

    public static void sortElements(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {            // i < n-1 is sufficient
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap if needed
            if (minIndex != i) {
                int t = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = t;
            }
        }
    }

    public static void displayData(int arr[]) {
        for (int dt : arr) {
            System.out.print(dt + " ");              // print on one line
        }
        System.out.println();                        // line break after the array
    }

    public static void main(String[] args) {
        int arr[] = {10, 7, 2, 9, 1, 6, 3, 4, 8, 5}; // unsorted example
        // before sorting
        displayData(arr);
        sortElements(arr);
        // after sorting
        displayData(arr);
    }
}

