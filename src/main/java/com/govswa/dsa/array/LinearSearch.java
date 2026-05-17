package com.govswa.dsa.array;

public class LinearSearch {

    public static int linearSearch(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 1, 8, 9};
        System.out.println(linearSearch(a, 1));
        System.out.println(linearSearch(a, 5));
        System.out.println(linearSearch(a, 10));
    }
}
