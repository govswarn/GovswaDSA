package com.govswa.dsa.array;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateSorted {

    public static int removeDuplicateBrute(int[] a) {
        Set<Integer> s = new HashSet<>();
        int i = 0;
        for (int x : a) {
            if (!s.contains(x)) {
                s.add(x);
                a[i++] = x;
            }
        }
        return i;
    }

    public static int removeDuplicate(int[] a) {
        int j = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[j]) {
                a[++j] = a[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 4, 4, 5};
        int n = removeDuplicateBrute(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
        int[] a1 = {1, 1, 2, 2, 3, 4, 4, 5};
        int n1 = removeDuplicate(a1);
        for (int i = 0; i <= n1; i++) {
            System.out.print(a1[i] + " ");
        }
    }
}
