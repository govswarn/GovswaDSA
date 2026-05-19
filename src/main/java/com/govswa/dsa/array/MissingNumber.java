package com.govswa.dsa.array;

import java.util.Arrays;

public class MissingNumber {

    public static int missingNumberBrute(int[] a) {
        for (int i = 1; i <= a.length + 1; i++) {
            if (LinearSearch.linearSearch(a, i) == -1) {
                return i;
            }
        }
        return -1;
    }

    public static int missingNumberBetter_1(int[] a) {
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1] + 1) {
                return a[i] - 1;
            }
        }
        return -1;
    }

    public static int missingNumberBetter_2(int[] a) {
        int n = a.length;
        int[] hash = new int[n + 2];
        for (int i = 0; i < n; i++) {
            hash[a[i]]++;
        }
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int missingNumber_1(int[] a) {
        long sum = 0, sumN = 0;
        long n = a.length + 1;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        sumN = (n * (n + 1)) / 2;
        return (int) (sumN - sum);
    }

    public static int missingNumber(int[] a) {
        int xor = 0, xorN = 0;
        for (int i = 0; i < a.length; i++) {
            xor ^= a[i];
        }
        for (int i = 1; i <= a.length + 1; i++) {
            xorN ^= i;
        }
        return xor ^ xorN;
    }

    public static void main(String[] args) {
        int[] a1 = {8, 2, 4, 5, 3, 7, 1};
        int[] a2 = {1, 2, 3, 5};

        System.out.println(missingNumberBrute(a1));
        System.out.println(missingNumberBrute(a2));

        System.out.println("-------------------------------------");
        System.out.println(missingNumberBetter_1(a1));
        System.out.println(missingNumberBetter_1(a2));

        System.out.println("-------------------------------------");
        System.out.println(missingNumberBetter_2(a1));
        System.out.println(missingNumberBetter_2(a2));

        System.out.println("-------------------------------------");
        System.out.println(missingNumber_1(a1));
        System.out.println(missingNumber_1(a2));

        System.out.println("-------------------------------------");
        System.out.println(missingNumber(a1));
        System.out.println(missingNumber(a2));
    }
}
