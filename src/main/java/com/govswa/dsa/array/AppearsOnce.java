package com.govswa.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class AppearsOnce {

    public static int appearsOnceBetter(int[] a) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : a) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> freqEntry : freqMap.entrySet()) {
            if (freqEntry.getValue() == 1) {
                return freqEntry.getKey();
            }
        }
        return -1;
    }

    public static int appearsOnce(int[] a) {
        int xor = 0;
        for (int x : a) {
            xor ^= x;
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] a1 = {2, 3, 5, 4, 5, 3, 4};
        int[] a2 = {1, 1, 2, 3, 2, 3, 4};

        System.out.println(appearsOnceBetter(a1));
        System.out.println(appearsOnceBetter(a2));

        System.out.println("-------------------------------------");
        System.out.println(appearsOnce(a1));
        System.out.println(appearsOnce(a2));
    }
}
