package com.govswa.dsa.array;

import java.util.Arrays;

public class SortO12 {

    public static void sortBrute(int[] a) {
        Arrays.sort(a);
    }

    public static void sortBetter(int[] a) {
        int c0 = 0, c1 = 0, c2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) c0++;
            else if (a[i] == 1) c1++;
            else if (a[i] == 2) c2++;
        }

        int i = 0;
        while (c0-- > 0) {
            a[i++] = 0;
        }
        while (c1-- > 0) {
            a[i++] = 1;
        }
        while (c2-- > 0) {
            a[i++] = 2;
        }
    }

    //Dutch National Flag algorithm
    public static void sort(int[] a) {
        int n = a.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (a[mid] == 0) {
                Swap.swap(a, mid, low);
                mid++;
                low++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                Swap.swap(a, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {0, 1, 2, 0, 1, 2};
        int[] a2 = {0, 0, 1, 1, 1};

        sortBrute(a1);
        PrintArray.print(a1);
        System.out.println();
        sortBrute(a2);
        PrintArray.print(a2);

        System.out.println("\n-------------------");

        sortBetter(a1);
        PrintArray.print(a1);
        System.out.println();
        sortBetter(a2);
        PrintArray.print(a2);

        System.out.println("\n-------------------");
        sort(a1);
        PrintArray.print(a1);
        System.out.println();
        sort(a2);
        PrintArray.print(a2);
    }
}
