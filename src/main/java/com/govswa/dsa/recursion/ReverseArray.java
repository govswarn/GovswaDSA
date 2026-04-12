package com.govswa.dsa.recursion;

import com.govswa.dsa.array.Swap;

public class ReverseArray {

    public static void reverse(int[] a, int i, int j) {
        if (i < j) {
            Swap.swap(a, i, j);
            reverse(a, i + 1, j - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        reverse(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + " ");
        }

        System.out.println();
        int[] a2 = {1, 2, 3, 4, 5, 6};
        reverse(a2, 0, a2.length - 1);
        for (int i : a2) {
            System.out.print(i + " ");
        }
    }
}
