package com.govswa.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSumBrute(int[] a, int k) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] + a[j] == k) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSumBetter(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int rem = k - a[i];
            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }
            map.put(a[i], i);
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSum(int[] a, int k) {
        int left = 0, right = a.length - 1;
        int sum;
        while (left < right) {
            sum = a[left] + a[right];
            if (sum == k) {
                return new int[]{left, right};
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] a = {2, 6, 5, 8, 11};

        int[] res = twoSumBrute(a, 14);
        System.out.println(res[0] + " " + res[1]);
        int[] res2 = twoSumBrute(a, 15);
        System.out.println(res2[0] + " " + res2[1]);

        System.out.println("-------------------------------------");

        int[] res3 = twoSumBetter(a, 14);
        System.out.println(res3[0] + " " + res3[1]);
        int[] res4 = twoSumBetter(a, 15);
        System.out.println(res4[0] + " " + res4[1]);

        System.out.println("-------------------------------------");
        int[] res5 = twoSum(a, 14);
        System.out.println(res5[0] + " " + res5[1]);
        int[] res6 = twoSum(a, 15);
        System.out.println(res6[0] + " " + res6[1]);
    }
}
