package com.govswa.dsa.array;

import java.util.*;

public class ThreeSumZero {

    public static List<List<Integer>> threeSumTripletZeroBrute(int[] a) {
        int n = a.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        List<Integer> list = Arrays.asList(a[i], a[j], a[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSumTripletZeroBetter(int[] a) {
        Set<List<Integer>> resSet = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < a.length; j++) {
                int z = -(a[i] + a[j]);
                if (hashSet.contains(z)) {
                    List<Integer> list = Arrays.asList(a[i], a[j], z);
                    Collections.sort(list);
                    resSet.add(list);
                }
                hashSet.add(a[j]);
            }
        }
        return new ArrayList<>(resSet);
    }

    public static List<List<Integer>> threeSumTripletZero(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;
            int left = i + 1, right = a.length - 1;
            while (left < right) {
                int sum = a[i] + a[left] + a[right];
                if (sum == 0) {
                    triplets.add(Arrays.asList(a[i], a[left], a[right]));
                    left++;
                    right--;
                    while (a[left] == a[left - 1]) left++;
                    while (a[right] == a[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        int[] a1 = {-1, 0, 1, 2, -1, -4};
        int[] a2 = {-1, 0, 1, 2, -1, -4};
        int[] a3 = {-1, 0, 1, 0};
        int[] a4 = {-2, -2, -2, -1, -1, -1, 0, 0, 0, 2, 2, 2, 2};

        System.out.println(threeSumTripletZeroBrute(a1));
        System.out.println(threeSumTripletZeroBrute(a2));
        System.out.println(threeSumTripletZeroBrute(a3));
        System.out.println(threeSumTripletZeroBrute(a4));

        System.out.println("-----------------------------------------");
        System.out.println(threeSumTripletZeroBetter(a1));
        System.out.println(threeSumTripletZeroBetter(a2));
        System.out.println(threeSumTripletZeroBetter(a3));
        System.out.println(threeSumTripletZeroBrute(a4));

        System.out.println("-----------------------------------------");
        System.out.println(threeSumTripletZero(a1));
        System.out.println(threeSumTripletZero(a2));
        System.out.println(threeSumTripletZero(a3));
        System.out.println(threeSumTripletZero(a4));
    }
}
