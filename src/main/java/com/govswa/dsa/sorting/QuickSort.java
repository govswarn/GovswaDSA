package com.govswa.dsa.sorting;

import com.govswa.dsa.array.PrintArray;
import com.govswa.dsa.array.Swap;

public class QuickSort {

    public static void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotIndex = pivot(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    private static int pivot(int[] a, int low, int high) {
        int i = low;
        int j = high;
        int pivot = a[low];
        while (i < j) {
            while (i <= high && a[i] <= pivot) {
                i++;
            }
            while (j >= low && a[j] > pivot) {
                j--;
            }
            if (i < j) {
                Swap.swap(a, i, j);
            }
        }
        Swap.swap(a, low, j);
        return j;
    }

    public static void main(String[] args) {
        int[] a = {4, 6, 2, 5, 7, 9, 1, 3};
        sort(a);
        PrintArray.print(a);
    }
}
