package com.govswa.dsa.sorting;

import com.govswa.dsa.array.PrintArray;
import com.govswa.dsa.array.Swap;

public class SelectionSort {

    // Time complexity: O(n^2)
    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minI]) {
                    minI = j;
                }
            }
            //avoid unnecessary swaps
            if (minI != i) {
                Swap.swap(a, i, minI);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {13, 46, 24, 52, 20, 9};
        sort(a);
        PrintArray.print(a);

        System.out.println("\n-------------------");
        int[] a1 = {5, 4, 3, 2, 1};
        sort(a1);
        PrintArray.print(a1);
    }
}
