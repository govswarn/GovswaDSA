package com.govswa.dsa.sorting;

import static com.govswa.dsa.sorting.TestSort.testSort;

public class InsertionSort {

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int k = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > k) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = k;
        }
    }

    public static void main(String[] args) {
        testSort(InsertionSort::sort);
    }
}
