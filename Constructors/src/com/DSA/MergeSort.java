
package com.DSA;

import java.util.Arrays;

public class MergeSort {

    public static void sortElements(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            // sort left and right halves
            sortElements(arr, l, m);        // ✅ left half
            sortElements(arr, m + 1, r);    // ✅ right half

            // merge the two sorted halves
            mergeSortedArray(arr, l, m, r);
        }
    }

    public static void mergeSortedArray(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;

        // merge the temp arrays back into arr[l..r]
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of L, if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // copy remaining elements of R, if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, -7, -2, -9, 1, 6, 3, 4, 8, 5}; // unsorted example
        System.out.println("Before Sorting: " + Arrays.toString(arr));

        sortElements(arr, 0, arr.length - 1);

        System.out.println("After Sorting: " + Arrays.toString(arr));
    }
}
