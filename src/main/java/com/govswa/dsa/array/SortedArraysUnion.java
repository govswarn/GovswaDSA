package com.govswa.dsa.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortedArraysUnion {

    public static List<Integer> unionBrute(int[] a1, int[] a2) {
        Set<Integer> unionSet = new TreeSet<>();
        for (int x : a1) {
            unionSet.add(x);
        }
        for (int x : a2) {
            unionSet.add(x);
        }
        return new ArrayList<>(unionSet);
    }

    public static List<Integer> union(int[] a1, int[] a2) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        int n1 = a1.length, n2 = a2.length;
        while (i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != a1[i]) {
                    union.add(a1[i]);
                }
                i++;
            } else if (a2[j] < a1[i]) {
                if (union.isEmpty() || union.get(union.size() - 1) != a2[j]) {
                    union.add(a2[j]);
                }
                j++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != a1[i]) {
                    union.add(a1[i]);
                }
                i++;
                j++;
            }
        }

        while (i < n1) {
            if (union.isEmpty() || union.get(union.size() - 1) != a1[i]) {
                union.add(a1[i]);
            }
            i++;
        }
        while (j < n2) {
            if (union.isEmpty() || union.get(union.size() - 1) != a2[j]) {
                union.add(a2[j]);
            }
            j++;
        }
        return union;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 4, 5, 6};
        int[] a2 = {2, 3, 5, 5, 7};

        List<Integer> unionBrute = unionBrute(a1, a2);
        System.out.println(unionBrute);

        List<Integer> union = union(a1, a2);
        System.out.println(union);

    }
}
