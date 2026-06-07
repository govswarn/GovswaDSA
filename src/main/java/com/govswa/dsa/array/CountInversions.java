package com.govswa.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversions {

    public static List<List<Integer>> inversionsBrute(int[] a) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    list.add(Arrays.asList(a[i], a[j]));
                }
            }
        }
        return list;
    }

    public static int inversions(int[] a) {
        return merge(a, 0, a.length - 1);
    }

    public static int merge(int[] a, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += merge(a, low, mid);
            count += merge(a, mid + 1, high);
            count += mergeSort(a, low, mid, high);
        }
        return count;
    }

    public static int mergeSort(int[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) {
                list.add(a[i++]);
            } else {
                count += (mid - i + 1);
                list.add(a[j++]);
            }
        }
        while (i <= mid) {
            list.add(a[i++]);
        }
        while (j <= high) {
            list.add(a[j++]);
        }
        for (int p = low; p <= high; p++) {
            a[p] = list.get(p - low);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {5, 4, 3, 2, 1};
        int[] a3 = {5, 3, 2, 1, 4};

        System.out.println(inversionsBrute(a1) + " - " + inversionsBrute(a1).size());
        System.out.println(inversionsBrute(a2) + " - " + inversionsBrute(a2).size());
        System.out.println(inversionsBrute(a3) + " - " + inversionsBrute(a3).size());

        System.out.println("-----------------------------");
        System.out.println(inversions(a1));
        System.out.println(inversions(a2));
        System.out.println(inversions(a3));
    }
}
