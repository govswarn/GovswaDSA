package com.govswa.dsa.array;

public class LeftRotateByK {

    public static void leftRotateByKBrute(int[] a, int k) {
        int n = a.length;
        k = k % n;
        int[] temp = new int[k];

        for (int i = 0; i < k; i++) {
            temp[i] = a[i];
        }

        for (int i = 0; i < n - k; i++) {
            a[i] = a[k + i];
        }

        for (int i = 0; i < k; i++) {
            a[n - k + i] = temp[i];
        }
    }

    public static void leftRotateByK(int[] a, int k) {
        int n = a.length - 1;
        ReverseArray.reverse(a);
        ReverseArrayInBetween.reverseArrayInBetween(a, 0, n - 1 - k);
        ReverseArrayInBetween.reverseArrayInBetween(a, n - k, n - 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        leftRotateByKBrute(a, 3);
        PrintArray.print(a);

        System.out.println();
        int[] a1 = {1, 2, 3, 4, 5, 6, 7};
        leftRotateByK(a1, 3);
        PrintArray.print(a1);
    }
}
