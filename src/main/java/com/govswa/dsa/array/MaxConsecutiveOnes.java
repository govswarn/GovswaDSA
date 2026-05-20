package com.govswa.dsa.array;

public class MaxConsecutiveOnes {

    public static int maxConsecutiveOnes(int[] a) {
        int maxC = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int c = 0;
            int j = i;
            while (j < a.length && a[j] == 1) {
                c++;
                j++;
            }
            if (maxC < c) {
                maxC = c;
            }
        }
        return maxC;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 0, 1, 1, 1, 0, 1, 1};
        int[] a2 = {1, 1, 0, 0, 1, 1, 0, 0};
        int[] a3 = {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(maxConsecutiveOnes(a1));
        System.out.println(maxConsecutiveOnes(a2));
        System.out.println(maxConsecutiveOnes(a3));
    }
}
