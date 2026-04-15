package com.govswa.dsa.sorting;

import com.govswa.dsa.array.Swap;

import static com.govswa.dsa.sorting.TestSort.testSort;

public class BubbleSort {

    // Time complexity: O(n^2)
    public static void sortBetter(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    Swap.swap(a, j + 1, j);
                }
            }
        }
    }

    public static void sort(int[] a) {
        boolean isSwapped = false;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    Swap.swap(a, j + 1, j);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                return;
            }
        }
    }


    public static void main(String[] args) {
        testSort(a -> BubbleSort.sortBetter(a));
        testSort(BubbleSort::sort);
    }
}
