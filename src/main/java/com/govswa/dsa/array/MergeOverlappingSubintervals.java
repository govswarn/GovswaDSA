package com.govswa.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingSubintervals {

    public static List<List<Integer>> mergeBrute(int[][] a) {
        Arrays.sort(a, Comparator.comparingInt(interval -> interval[0]));
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int start = a[i][0];
            int end = a[i][1];
            if (!list.isEmpty()
                    && start <= list.get(list.size() - 1).get(1)) {
                continue;
            }
            for (int j = i + 1; j < a.length; j++) {
                if (a[j][0] <= end) {
                    end = Math.max(end, a[j][1]);
                } else {
                    break;
                }
            }
            list.add(Arrays.asList(start, end));
        }
        return list;
    }

    public static List<List<Integer>> merge(int[][] a) {
        Arrays.sort(a, Comparator.comparingInt(interval -> interval[0]));
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (list.isEmpty()
                    || a[i][0] > list.get(list.size() - 1).get(1)) {
                list.add(Arrays.asList(a[i][0], a[i][1]));
            } else {
                list.get(list.size() - 1).set(1, Math.max(a[i][1], list.get(list.size() - 1).get(1)));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] a1 = {{1, 3}, {2, 6}, {8, 9}, {9, 11}, {8, 10}, {2, 4}, {15, 18}, {16, 17}};
        int[][] a2 = {{1, 4}, {4, 5}};

        System.out.println(mergeBrute(a1));
        System.out.println(mergeBrute(a2));

        System.out.println("------------------");
        System.out.println(merge(a1));
        System.out.println(merge(a2));
    }
}
