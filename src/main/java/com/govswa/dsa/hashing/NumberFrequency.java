package com.govswa.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class NumberFrequency {

    public static void frequencyBrute(int[] a) {
        boolean[] visited = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            if (!visited[i]) {
                int count = 1;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] == a[i]) {
                        visited[j] = true;
                        count++;

                    }
                }
                System.out.println(a[i] + " -> " + count);
            }
        }
    }


    private static final int[] hash = new int[20];

    public static void frequencyBetter(int[] a) {
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

        System.out.println("-----------------");
        frequencyBetter(a);

        System.out.println("---------------------");
        Map<Integer, Integer> frequencyMap = frequency(a);
        frequencyMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}