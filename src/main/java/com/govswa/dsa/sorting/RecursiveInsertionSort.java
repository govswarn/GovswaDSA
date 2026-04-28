package com.govswa.dsa.sorting;

import com.govswa.dsa.array.PrintArray;

public class RecursiveInsertionSort {

    public static void sort(int[] a) {
        insertionSort(a, 1);
    }

    private static void insertionSort(int[] a, int i) {
        if (i < a.length) {
            int k = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > k) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = k;

            insertionSort(a, i + 1);
        }

    }

    public static void main(String[] args) {
        int[] a = {13, 46, 24, 52, 20, 9};
        sort(a);
        PrintArray.print(a);
    }
}
