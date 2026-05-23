package com.govswa.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class RearrangeBySignEqual {

    public static void rearrangeBySignBrute(int[] a) {
        int n = a.length;
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int x : a) {
            if (x > 0) {
                positives.add(x);
            } else {
                negatives.add(x);
            }
        }
        for (int i = 0; i < n / 2; i++) {
            a[2 * i] = positives.get(i);
            a[2 * i + 1] = negatives.get(i);
        }
    }

    public static void rearrangeBySign(int[] a) {
        int p = 0, n = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                a[p] = a[i];
                p += 2;
            } else {
                a[n] = a[i];
                n += 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, -4, -5};
        int[] a2 = {1, -1, 2, -2, 3, -3};
        int[] a3 = {1, 2, -3, -1, 2, -3};

        rearrangeBySignBrute(a1);
        PrintArray.print(a1);

        System.out.println();
        rearrangeBySignBrute(a2);
        PrintArray.print(a2);

        System.out.println();
        rearrangeBySignBrute(a3);
        PrintArray.print(a3);

        System.out.println("\n-------------------------------------");
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
