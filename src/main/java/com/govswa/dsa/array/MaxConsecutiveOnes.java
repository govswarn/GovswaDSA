package com.govswa.dsa.array;

public class MaxConsecutiveOnes {

    public static int maxConsecutiveOnes_1(int[] a) {
        int c, maxC = Integer.MIN_VALUE;
        int i = 0;
        int j;
        while (i < a.length) {
            c = 0;
            j = i;
            while (j < a.length && a[j] == 1) {
                c++;
                j++;
            }
            if (maxC < c) {
                maxC = c;
                i = j;
            } else {
                i++;
            }

        }
        return maxC;
    }

    public static int maxConsecutiveOnes(int[] a) {
        int c = 0, maxC = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                c++;
            } else {
                c = 0;
            }
            maxC = Math.max(maxC, c);
        }
        return maxC;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 0, 1, 1, 1, 0, 1, 1};
        int[] a2 = {1, 1, 0, 0, 1, 1, 0, 0};
        int[] a3 = {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0};

        System.out.println(maxConsecutiveOnes_1(a1));
        System.out.println(maxConsecutiveOnes_1(a2));
        System.out.println(maxConsecutiveOnes_1(a3));

        System.out.println("------------------------------");
        System.out.println(maxConsecutiveOnes(a1));
        System.out.println(maxConsecutiveOnes(a2));
        System.out.println(maxConsecutiveOnes(a3));
    }
}
