package com.govswa.dsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RepeatingAndMissingNum {

    public static int[] repeatingAndMissingNumBrute(int[] a) {
        int n = a.length;
        int repeating = -1, missing = -1;
        int count;
        for (int i = 1; i <= n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] == i) {
                    count++;
                }
            }
            if (count == 2) repeating = i;
            else if (count == 0) missing = i;

            if (missing != -1 && repeating != -1) break;
        }
        return new int[]{repeating, missing};
    }

    public static int[] repeatingAndMissingNumBetter_1(int[] a) {
        int n = a.length;
        int repeating = -1, missing = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            if (map.get(i) == null) missing = i;
            else if (map.get(i) == 2) repeating = i;

            if (missing != -1 && repeating != -1) break;
        }
        return new int[]{repeating, missing};
    }

    public static int[] repeatingAndMissingNumBetter_2(int[] a) {
        int repeating = -1, missing = -1;
        int[] hash = new int[a.length + 1];
        for (int x : a) {
            hash[x]++;
        }
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 0) missing = i;
            else if (hash[i] == 2) repeating = i;

            if (missing != -1 && repeating != -1) break;
        }
        return new int[]{repeating, missing};
    }

    public static int[] repeatingAndMissingNum_1(int[] a) {
        int n = a.length;
        int x = -1, y = -1;   //missing is x, repeating is y
        long sum = 0, sumN = ((long) n * (n + 1)) / 2;
        long sumSquare = 0, sumSquareN = (n * (n + 1) * (2L * n + 1)) / 6;
        for (int el : a) {
            sum += el;
            sumSquare += (long) el * el;
        }

        // v1 = x - y = sumN - sum
        long v1 = sumN - sum;

        // x^2 - y^2 = sumSquareN - sumSquare
        //(x + y) = (sumSquareN - sumSquare) / (x - y)
        //v2 = (x + y) = (sumSquareN - sumSquare) / v1
        long v2 = (sumSquareN - sumSquare) / v1;

        // x - y = v1
        //x + y = v2
        x = Math.toIntExact((v1 + v2) / 2);
        y = Math.toIntExact(v2 - x);

        return new int[]{y, x};
    }

    public static int[] repeatingAndMissingNum_2(int[] a) {
        int n = a.length;
        int x = -1, y = -1;

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[] a1 = {3, 5, 4, 1, 1};
        int[] a2 = {1, 2, 3, 6, 7, 5, 7};
        int[] a3 = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] a4 = {4, 3, 6, 2, 1, 1};

        System.out.println(Arrays.toString(repeatingAndMissingNumBrute(a1)));
        System.out.println(Arrays.toString(repeatingAndMissingNumBrute(a2)));
        System.out.println(Arrays.toString(repeatingAndMissingNumBrute(a3)));
        System.out.println(Arrays.toString(repeatingAndMissingNumBrute(a4)));

        System.out.println("-----------------------------------");
        System.out.println(Arrays.toString(repeatingAndMissingNumBetter_1(a1)));
        System.out.println(Arrays.toString(repeatingAndMissingNumBetter_1(a2)));
        System.out.println(Arrays.toString(repeatingAndMissingNumBetter_1(a3)));
        System.out.println(Arrays.toString(repeatingAndMissingNumBetter_1(a4)));

        System.out.println("-----------------------------------");
        System.out.println(Arrays.toString(repeatingAndMissingNumBetter_2(a1)));
        System.out.println(Arrays.toString(repeatingAndMissingNumBetter_2(a2)));
        System.out.println(Arrays.toString(repeatingAndMissingNumBetter_2(a3)));
        System.out.println(Arrays.toString(repeatingAndMissingNumBetter_2(a4)));

        System.out.println("-----------------------------------");
        System.out.println(Arrays.toString(repeatingAndMissingNum_1(a1)));
        System.out.println(Arrays.toString(repeatingAndMissingNum_1(a2)));
        System.out.println(Arrays.toString(repeatingAndMissingNum_1(a3)));
        System.out.println(Arrays.toString(repeatingAndMissingNum_1(a4)));

        System.out.println("-----------------------------------");
        System.out.println(Arrays.toString(repeatingAndMissingNum_2(a1)));
        System.out.println(Arrays.toString(repeatingAndMissingNum_2(a2)));
        System.out.println(Arrays.toString(repeatingAndMissingNum_2(a3)));
        System.out.println(Arrays.toString(repeatingAndMissingNum_2(a4)));
    }
}
