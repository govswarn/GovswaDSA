package com.govswa.dsa.sorting;

import com.govswa.dsa.array.PrintArray;
import com.govswa.dsa.array.Swap;

public class RecursiveSelectionSort {

    public static void sort(int[] a) {
        selectionSort(a, 0);
    }

    private static void selectionSort(int[] a, int i) {
        if (i < a.length - 1) {
            int minI = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minI]) {
                    minI = j;
                }
            }
            Swap.swap(a, minI, i);

            selectionSort(a, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {13, 46, 24, 52, 20, 9};
        sort(a);
        PrintArray.print(a);
    }
}
