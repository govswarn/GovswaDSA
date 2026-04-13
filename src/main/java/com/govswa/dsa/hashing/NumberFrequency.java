package com.govswa.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class NumberFrequency {

    private static final int[] hash = new int[20];

    public static void frequencyBrute(int[] a) {
        for (int i = 0; i < a.length; i++) {
            hash[a[i]]++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                System.out.println(i + " -> " + hash[i]);
            }
        }
    }

    public static Map<Integer, Integer> frequency(int[] a) {
        Map<Integer, Integer> freqencyMap = new HashMap<>();
        for (int x : a) {
            freqencyMap.put(x, freqencyMap.getOrDefault(x, 0) + 1);
        }
        return freqencyMap;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        frequencyBrute(a);

        System.out.println("---------------------");
        Map<Integer, Integer> frequencyMap = frequency(a);
        frequencyMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}