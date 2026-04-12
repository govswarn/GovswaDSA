package com.govswa.dsa.array;

public class Swap {

    public static void swap(int[] a, int i, int j) {
        a[i] = a[i] + a[j];
        a[j] = a[i] - a[j];
        a[i] = a[i] - a[j];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        swap(a, 1, 3);

        PrintArray.print(a, 0, a.length);
    }
}
