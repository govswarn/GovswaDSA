package com.govswa.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountReversePairs {

    public static List<List<Integer>> reversePairsBrute(int[] a) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > 2L * a[j]) {
                    list.add(Arrays.asList(a[i], a[j]));
                }
            }
        }
        return list;
    }

    public static int reversePairs(int[] a) {
        return merge(a, 0, a.length - 1);
    }

    private static int merge(int[] a, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            count += merge(a, low, mid);
            count += merge(a, mid + 1, high);
            count += countPairs(a, low, mid, high);
            mergeSort(a, low, mid, high);
        }
        return count;
    }

    private static int countPairs(int[] a, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && a[i] > 2 * a[j]) j++;
            count += (j - (mid + 1));
        }
        return count;
    }

    private static void mergeSort(int[] a, int low, int mid, int high) {
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
        int[] a1 = {1, 3, 2, 3, 1};
        int[] a2 = {3, 2, 1, 4};
        int[] a3 = {40, 25, 19, 12, 9, 6, 2};

        System.out.println(reversePairsBrute(a1) + " - " + reversePairsBrute(a1).size());
        System.out.println(reversePairsBrute(a2) + " - " + reversePairsBrute(a2).size());
        System.out.println(reversePairsBrute(a3) + " - " + reversePairsBrute(a3).size());

        System.out.println("-----------------------------------");
        System.out.println(reversePairs(a1));
        System.out.println(reversePairs(a2));
        System.out.println(reversePairs(a3));

    }
}