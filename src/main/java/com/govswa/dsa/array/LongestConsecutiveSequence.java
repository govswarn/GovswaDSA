package com.govswa.dsa.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestSequenceBrute(int[] a) {
        int longestSequence = 0, c;
        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            c = 1;
            while (LinearSearch.linearSearch(a, x + 1) != -1) {
                x += 1;
                c++;
            }
            longestSequence = Math.max(longestSequence, c);
        }
        return longestSequence;
    }

    public static int longestSequenceBetter(int[] a) {
        int longestSequence = 0, c;
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            c = 1;
            while (i < a.length - 1 && a[i + 1] == a[i] + 1) {
                c++;
                i++;
            }
            longestSequence = Math.max(longestSequence, c);
        }
        return longestSequence;
    }

    public static int longestSequence(int[] a) {
        int longestSequence = 0, c;
        Set<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }
        for (int i = 0; i < a.length; i++) {
            if (!set.contains(a[i] - 1)) {
                int x = a[i];
                c = 1;
                while (set.contains(x + 1)) {
                    c++;
                    x += 1;
                }
                longestSequence = Math.max(longestSequence, c);
            }
        }
        return longestSequence;
    }

    public static void main(String[] args) {
        int[] a1 = {100, 4, 200, 1, 3, 2};
        int[] a2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] a3 = {102, 4, 100, 1, 101, 3, 2, 1, 1};

        System.out.println(longestSequenceBrute(a1));
        System.out.println(longestSequenceBrute(a2));
        System.out.println(longestSequenceBrute(a3));

        System.out.println("-------------------------------------");

        System.out.println(longestSequenceBetter(a1));
        System.out.println(longestSequenceBetter(a2));
        System.out.println(longestSequenceBetter(a3));

        System.out.println("-------------------------------------");
        System.out.println(longestSequence(a1));
        System.out.println(longestSequence(a2));
        System.out.println(longestSequence(a3));
    }
}
