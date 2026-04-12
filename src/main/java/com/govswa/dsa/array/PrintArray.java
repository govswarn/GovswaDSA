package com.govswa.dsa.array;

public class PrintArray {

    public static void print(int[] a, int i, int j) {
        while (i < j) {
            System.out.print(a[i] + " ");
            i++;
        }
    }
}
