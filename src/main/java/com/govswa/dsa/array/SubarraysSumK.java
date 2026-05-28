package com.govswa.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraysSumK {

    public static int subarraysSumKBrute(int[] a, int k) {
        int count = 0;
        int sum;
        for (int i = 0; i < a.length; i++) {
            sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraysSumK(int[] a, int k) {
        int x = 0, xMinusk;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < a.length; i++) {
            x += a[i];
            xMinusk = x - k;
            if (map.containsKey(xMinusk)) {
                count += map.get(xMinusk);
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a1 = {3, 1, 2, 4};
        int[] a2 = {1, 2, 3, 4, 5};
        int[] a3 = {1, 2, 5, -3, 6, 4, -5, 2, 7};

        System.out.println(subarraysSumKBrute(a1, 6));
        System.out.println(subarraysSumKBrute(a2, 9));
        System.out.println(subarraysSumKBrute(a3, 7));

        System.out.println("-------------------------------------");
        System.out.println(subarraysSumK(a1, 6));
        System.out.println(subarraysSumK(a2, 9));
        System.out.println(subarraysSumK(a3, 7));
    }
}
