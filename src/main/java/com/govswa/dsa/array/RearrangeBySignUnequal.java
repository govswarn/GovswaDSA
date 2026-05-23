package com.govswa.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class RearrangeBySignUnequal {

    public static void rearrangeBySign(int[] a) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int x : a) {
            if (x > 0) {
                positives.add(x);
            } else {
                negatives.add(x);
            }
        }
        int n = Math.min(positives.size(), negatives.size());
        int i = 0;
        while (i < n) {
            a[2 * i] = positives.get(i);
            a[2 * i + 1] = negatives.get(i);
            i++;
        }
        if (positives.size() > negatives.size()) {
            for (int j = n * 2; j < a.length; j++) {
                a[j] = positives.get(i);
                i++;
            }
        } else {
            for (int j = n * 2; j < a.length; j++) {
                a[j] = negatives.get(i);
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, -4, -5};
        int[] a2 = {1, -1, 2, -2, 3, 5, 8, -3};
        int[] a3 = {1, 2, -3, -1, 2, -7, -5, -3};

        rearrangeBySign(a1);
        PrintArray.print(a1);

        System.out.println();
        rearrangeBySign(a2);
        PrintArray.print(a2);

        System.out.println();
        rearrangeBySign(a3);
        PrintArray.print(a3);
    }
}
