package com.govswa.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubASumK {

    //works for positive and negative both numbers in array
    public static int longestSubArrayBrute(int[] a, int k) {
        int count, longest = 0;
        int sum;
        for (int i = 0; i < a.length; i++) {
            count = 0;
            sum = 0;
            int j = i;
            while (j < a.length && sum < k) {
                sum += a[j];
                count++;
                j++;
            }
            if (sum == k && longest < count) {
                longest = count;
            }
        }
        return longest;
    }

    //works for positive and negative both numbers in array
    public static int longestSubArrayBetter(int[] a, int k) {
        int longest = 0;
        long x = 0, xMinusk;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            x += a[i];
            if (x == k) {
                longest = Math.max(longest, i + 1);
            }

            xMinusk = x - k;
            if (map.containsKey(xMinusk)) {
                longest = Math.max(longest, i - map.get(xMinusk));
            }

            map.putIfAbsent(x, i);
        }
        return longest;
    }

    //works only for positive numbers in array
    //sliding window approach
    public static int longestSubArray(int[] a, int k) {
        int longest = 0;
        int n = a.length;
        int sum = a[0];
        int left = 0, right = 0;
        while (right < n) {
            //first make window correct and then check for longest
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }
            if (sum == k) {
                longest = Math.max(longest, right - left + 1);
            }

            right++;
            if (right < n) {
                sum += a[right];
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] a1 = {10, 5, 2, 7, 1, 9};
        int[] a2 = {-3, 2, 1};
        int[] a3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] a4 = {2, 0, 0, 3};

        System.out.println(longestSubArrayBrute(a1, 15));
        System.out.println(longestSubArrayBrute(a2, 6));
        System.out.println(longestSubArrayBrute(a3, 15));
        System.out.println(longestSubArrayBrute(a4, 3));

        System.out.println("-------------------------------------");
        System.out.println(longestSubArrayBetter(a1, 15));
        System.out.println(longestSubArrayBetter(a3, 15));
        System.out.println(longestSubArrayBetter(a4, 3));

        System.out.println("-------------------------------------");
        System.out.println(longestSubArray(a1, 15));
        System.out.println(longestSubArray(a2, 6));
        System.out.println(longestSubArray(a3, 15));
        System.out.println(longestSubArray(a4, 3));
    }
}
