package com.govswa.dsa.array;

public class MaxSubarraySum {

    public static int maxSubarraySumBrute(int[] a) {
        int sum, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    //Kadane's Algorithm
    public static int maxSubarraySum(int[] a) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (maxSum < sum) {
                maxSum = sum;
            }
            // sum = Math.max(sum, a[i]);//handle negative
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static int[] maxSubarraySumIndex(int[] a) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        int startI = 0, start = 0, end = 0;
        for (int i = 0; i < a.length; i++) {
            if (sum == 0) {
                startI = i;
            }
            sum += a[i];
            if (maxSum < sum) {
                maxSum = sum;
                start = startI;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] a1 = {2, 3, 5, -2, 7, -4};
        int[] a2 = {-2, -3, -7, -2, -10, -4, -1};
        int[] a3 = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(maxSubarraySumBrute(a1));
        System.out.println(maxSubarraySumBrute(a2));
        System.out.println(maxSubarraySumBrute(a3));

        System.out.println("-------------------------------------");
        System.out.println(maxSubarraySum(a1));
        System.out.println(maxSubarraySum(a2));
        System.out.println(maxSubarraySum(a3));

        System.out.println("-------------------------------------");
        int[] res = maxSubarraySumIndex(a1);
        System.out.println(res[0] + " " + res[1]);
        res = maxSubarraySumIndex(a2);
        System.out.println(res[0] + " " + res[1]);
        res = maxSubarraySumIndex(a3);
        System.out.println(res[0] + " " + res[1]);
    }
}
