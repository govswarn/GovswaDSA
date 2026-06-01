package com.govswa.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysXORK {

    public static int countSubarraysXORKBrute(int[] a, int k) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int XOR = 0;
            for (int j = i; j < a.length; j++) {
                XOR ^= a[j];
                if (XOR == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countSubarraysXORK(int[] a, int k) {
        int count = 0;
        int XOR = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < a.length; i++) {
            XOR ^= a[i];
            int xXORk = XOR ^ k;
            if (map.containsKey(xXORk)) {
                count += map.get(xXORk);
            }
            map.put(XOR, map.getOrDefault(XOR, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a1 = {4, 2, 2, 6, 4};
        int[] a2 = {5, 6, 7, 8, 9};

        System.out.println(countSubarraysXORKBrute(a1, 6));
        System.out.println(countSubarraysXORKBrute(a2, 5));

        System.out.println("---------------------------------");
        System.out.println(countSubarraysXORK(a1, 6));
        System.out.println(countSubarraysXORK(a2, 5));
    }
}
