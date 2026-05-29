package com.govswa.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementsNBy2 {

    public static int elementsGreaterThanNBy2Brute(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int count = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == a[i]) {
                    count++;
                }
            }
            if (count > a.length / 2) {
                return a[i];
            }

        }
        return -1;
    }

    public static int elementsGreaterThanNBy2Better_1(int[] a) {
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

    public static int elementsGreaterThanNBy2Better_2(int[] a) {
        var map = new HashMap<Integer, Integer>();
        int mini = a.length / 2 + 1;
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == mini) {
                return x;
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
        int[] a1 = {2, 2, 1, 2, 3, 2, 2, 4, 2, 5, 2, 2, 6, 2, 2};
        int[] a2 = {1, 1, 1, 2, 2, 2, 3, 4, 5, 1, 2, 1, 2, 1, 1, 1, 1};
        int[] a3 = {7, 0, 0, 1, 7, 7, 2, 7, 7};

        System.out.println(elementsGreaterThanNBy2Brute(a1));
        System.out.println(elementsGreaterThanNBy2Brute(a2));
        System.out.println(elementsGreaterThanNBy2Brute(a3));

        System.out.println("-----------------------------------------");
        System.out.println(elementsGreaterThanNBy2Better_1(a1));
        System.out.println(elementsGreaterThanNBy2Better_1(a2));
        System.out.println(elementsGreaterThanNBy2Better_1(a3));

        System.out.println("-----------------------------------------");
        System.out.println(elementsGreaterThanNBy2Better_2(a1));
        System.out.println(elementsGreaterThanNBy2Better_2(a2));
        System.out.println(elementsGreaterThanNBy2Better_2(a3));

        System.out.println("-------------------------------------");
        System.out.println(moreThanNBy2Times(a1));
        System.out.println(moreThanNBy2Times(a2));
        System.out.println(moreThanNBy2Times(a3));
    }
}
