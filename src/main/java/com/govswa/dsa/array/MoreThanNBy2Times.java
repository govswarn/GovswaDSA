package com.govswa.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class MoreThanNBy2Times {

    public static int moreThanNBy2TimesBetter(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > a.length / 2) {
                return e.getKey();
            }
        }
        return -1;
    }

    public static int moreThanNBy2Times(int[] a) {
        int c = 0, el = -1;
        for (int i = 0; i < a.length; i++) {
            if (c == 0) {
                c = 1;
                el = a[i];
            } else if (a[i] == el) {
                c++;
            } else {
                c--;
            }
        }

        int c1 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == el) {
                c1++;
            }
        }
        return c1 > a.length / 2 ? el : -1;
    }

    public static void main(String[] args) {
        int[] a1 = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int[] a2 = {1, 1, 1, 2, 1, 2};
        int[] a3 = {1, 2, 3, 2, 5};

        System.out.println(moreThanNBy2TimesBetter(a1));
        System.out.println(moreThanNBy2TimesBetter(a2));
        System.out.println(moreThanNBy2TimesBetter(a3));

        System.out.println("-------------------------------------");
        System.out.println(moreThanNBy2Times(a1));
        System.out.println(moreThanNBy2Times(a2));
        System.out.println(moreThanNBy2Times(a3));
    }
}
