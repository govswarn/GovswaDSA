package com.govswa.dsa.array;

public class LeftRotateByOne {

    public static void leftRotateByOne(int[] a) {
        int k = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[a.length - 1] = k;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        leftRotateByOne(a);
        PrintArray.print(a);

        System.out.println();
        int[] a1 = {-1, 0, 3, 6};
        leftRotateByOne(a1);
        PrintArray.print(a1);
    }
}
