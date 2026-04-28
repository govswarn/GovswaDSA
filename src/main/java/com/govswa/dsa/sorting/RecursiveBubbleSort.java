package com.govswa.dsa.sorting;

import com.govswa.dsa.array.PrintArray;
import com.govswa.dsa.array.Swap;

public class RecursiveBubbleSort {

    public static void sort(int[] a) {
        bubbleSort(a, 0);
    }

    private static void bubbleSort(int[] a, int i) {
        if (i < a.length - 1) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    Swap.swap(a, j, j + 1);
                }
            }
            bubbleSort(a, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {13, 46, 24, 52, 20, 9};
        sort(a);
        PrintArray.print(a);
    }
}
