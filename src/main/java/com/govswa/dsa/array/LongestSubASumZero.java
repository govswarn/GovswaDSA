package com.govswa.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubASumZero {

    public static int longestSubASumZeroBrute(int[] a) {
        int sum;
        int longest = 0;
        for (int i = 0; i < a.length; i++) {
            sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == 0) {
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }
        return longest;
    }

    public static int longestSubASumZero(int[] a) {
        int sum = 0;
        int longest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum == 0) {
                longest = i + 1;
            } else if (map.containsKey(sum)) {
                longest = Math.max(longest, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] a1 = {9, -3, 3, -1, 6, -5};
        int[] a2 = {6, -2, 2, -8, 1, 7, 4, -10};
        int[] a3 = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] a4 = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};

        System.out.println(longestSubASumZeroBrute(a1));
        System.out.println(longestSubASumZeroBrute(a2));
        System.out.println(longestSubASumZeroBrute(a3));
        System.out.println(longestSubASumZeroBrute(a4));

        System.out.println("-----------------------------------------");
        System.out.println(longestSubASumZero(a1));
        System.out.println(longestSubASumZero(a2));
        System.out.println(longestSubASumZero(a3));
        System.out.println(longestSubASumZero(a4));
    }
}
