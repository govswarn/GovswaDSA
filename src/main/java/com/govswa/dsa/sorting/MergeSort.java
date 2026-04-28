package com.govswa.dsa.sorting;

import com.govswa.dsa.array.PrintArray;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        List<Integer> l = new ArrayList<>();
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                l.add(a[i++]);
            } else
                l.add(a[j++]);
        }

        while (i <= mid) {
            l.add(a[i++]);
        }
        while (j <= high) {
            l.add(a[j++]);
        }

        for (int k = low; k <= high; k++) {
            a[k] = l.get(k - low);
        }
    }

    public static void main(String[] args) {
        int[] a = {38, 27, 43, 3, 9, 82, 10};
        sort(a);
        PrintArray.print(a);
    }
}
