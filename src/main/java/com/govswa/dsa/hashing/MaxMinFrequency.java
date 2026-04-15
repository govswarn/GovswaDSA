package com.govswa.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxMinFrequency {

    public static void maxMinFrequencyBrute(int[] a) {
        int maxFreq = Integer.MIN_VALUE, minFreq = a.length;
        boolean[] visited = new boolean[a.length];
        int max = 0, min = 0;
        for (int i = 0; i < a.length; i++) {
            int count = 1;
            if (!visited[i]) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] == a[i]) {
                        count++;
                        visited[j] = true;
                    }
                }
                if (count > maxFreq) {
                    maxFreq = count;
                    max = a[i];
                }
                if (count < minFreq) {
                    minFreq = count;
                    min = a[i];
                }
            }
        }
        System.out.println("Max -> " + max + " -> " + maxFreq);
        System.out.println("Min -> " + min + " -> " + minFreq);
    }

    public static void maxMinFrequency(int[] a) {
        int maxFreq = 0, minFreq = a.length;
        int max = 0, min = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : a) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> freqEntry : freqMap.entrySet()) {
            int freq = freqEntry.getValue();
            int ele = freqEntry.getKey();

            if (freq > maxFreq) {
                maxFreq = freq;
                max = ele;
            }
            if (freq < minFreq) {
                minFreq = freq;
                min = ele;
            }
        }
        System.out.println("Max -> " + max + " -> " + maxFreq);
        System.out.println("Min -> " + min + " -> " + minFreq);
    }

    public static void main(String[] args) {
        maxMinFrequencyBrute(new int[]{10, 5, 10, 15, 10, 5});

        System.out.println("------------------");
        maxMinFrequencyBrute(new int[]{2, 2, 3, 4, 4, 2});

        System.out.println("------------------");
        maxMinFrequency(new int[]{10, 5, 10, 15, 10, 5});

        System.out.println("------------------");
        maxMinFrequency(new int[]{2, 2, 3, 4, 4, 2});
    }
}
