package com.govswa.dsa.array;

import java.util.*;

public class FourSum {

    public static List<List<Integer>> fourSumBrute(int[] a, int target) {
        int n = a.length;
        Set<List<Integer>> quadsSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == target) {
                            List<Integer> quads = Arrays.asList(a[i], a[j], a[k], a[l]);
                            Collections.sort(quads);
                            quadsSet.add(quads);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(quadsSet);
    }

    public static List<List<Integer>> fourSumBetter(int[] a, int target) {
        int n = a.length;
        Set<List<Integer>> quadsSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int t = target - (a[i] + a[j] + a[k]);
                    if (set.contains(t)) {
                        List<Integer> quads = Arrays.asList(a[i], a[j], a[k], t);
                        Collections.sort(quads);
                        quadsSet.add(quads);
                    }
                    set.add(a[k]);
                }
            }
        }
        return new ArrayList<>(quadsSet);
    }

    public static List<List<Integer>> fourSum(int[] a, int target) {
        int n = a.length;
        Arrays.sort(a);
        List<List<Integer>> quads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && a[j] == a[j - 1]) continue;
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long sum = a[i] + a[j] + a[left] + a[right];
                    if (sum == target) {
                        quads.add(Arrays.asList(a[i], a[j], a[left], a[right]));
                        left++;
                        right--;
                        while (left < right && a[left] == a[left - 1]) left++;
                        while (right > left && a[right] == a[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quads;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 0, -1, 0, -2, 2};
        int[] a2 = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int[] a3 = {1, 2, -1, -2, 2, 0, -1};
        int[] a4 = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5};

        System.out.println(fourSumBrute(a1, 0));
        System.out.println(fourSumBrute(a2, 9));
        System.out.println(fourSumBrute(a3, 0));
        System.out.println(fourSumBrute(a4, 8));

        System.out.println("----------------------------------------");
        System.out.println(fourSumBetter(a1, 0));
        System.out.println(fourSumBetter(a2, 9));
        System.out.println(fourSumBetter(a3, 0));
        System.out.println(fourSumBetter(a4, 8));

        System.out.println("----------------------------------------");
        System.out.println(fourSum(a1, 0));
        System.out.println(fourSum(a2, 9));
        System.out.println(fourSum(a3, 0));
        System.out.println(fourSum(a4, 8));

    }
}
