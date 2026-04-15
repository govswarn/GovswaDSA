package com.govswa.dsa.array;

public class ReverseArray {

    public static void reverse(int[] a) {
        int i = 0, j = a.length - 1;
        while (i < j) {
            Swap.swap(a, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        reverse(a);
        PrintArray.print(a);

        System.out.println();
        int[] a2 = {1, 2, 3, 4, 5, 6};
        reverse(a2);
        PrintArray.print(a2);
    }
}
