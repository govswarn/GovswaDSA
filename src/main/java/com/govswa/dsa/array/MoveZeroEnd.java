package com.govswa.dsa.array;

import java.util.LinkedList;
import java.util.List;

public class MoveZeroEnd {

    public static void moveZeroEndBrute(int[] a) {
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                l.add(a[i]);
            }
        }

        int i = 0;
        for (int x : l) {
            a[i++] = x;
        }

        while (i < a.length) {
            a[i++] = 0;
        }
    }

    public static void moveZeroEnd(int[] a) {
        int i = 0;
        while (i < a.length) {
            if (a[i] == 0) {
                break;
            }
            i++;
        }
        if (i < a.length) {
            int j = i + 1;
            while (j < a.length) {
                if (a[j] != 0) {
                    Swap.swap(a, i, j);
                    i++;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 0, 2, 3, 0, 4, 0, 1};
        moveZeroEndBrute(a);
        PrintArray.print(a);

        System.out.println();
        int[] a1 = {1, 0, 2, 3, 0, 4, 0, 1};
        moveZeroEnd(a1);
        PrintArray.print(a1);
    }
}
