package com.govswa.dsa.array;

public class ReverseArrayInBetween {

    public static void reverseArrayInBetween(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        reverseArrayInBetween(a, 2, 5);
        PrintArray.print(a);
    }
}
