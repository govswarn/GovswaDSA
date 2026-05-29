package com.govswa.dsa.array;

import java.util.*;

public class MajorityElementsNBy3 {

    public static List<Integer> elementsGreaterThanNBy3Brute(int[] a) {
        var list = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            int count = 1;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] == a[i]) {
                    count++;
                }
            }
            if (count > a.length / 3) {
                list.add(a[i]);
            }
        }
        Collections.sort(list);
        return list;
    }

    public static List<Integer> elementsGreaterThanNBy3Better_1(int[] a) {
        var list = new ArrayList<Integer>();
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for (var entry : map.entrySet()) {
            if (entry.getValue() > a.length / 3) {
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        return list;
    }

    public static List<Integer> elementsGreaterThanNBy3Better_2(int[] a) {
        var list = new ArrayList<Integer>();
        var map = new HashMap<Integer, Integer>();
        int mini = a.length / 3 + 1;
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == mini) {
                list.add(x);
            }
            if (list.size() == 2) break;
        }
        Collections.sort(list);
        return list;
    }

    public static List<Integer> elementsGreaterThanNBy3(int[] a) {
        int n = a.length;
        var list = new LinkedList<Integer>();
        int c1 = 0, c2 = 0;
        int el1 = -1, el2 = -1;
        for (int i = 0; i < n; i++) {
            if (c1 == 0 && a[i] != el2) {
                c1 = 1;
                el1 = a[i];
            } else if (c2 == 0 && a[i] != el1) {
                c2 = 1;
                el2 = a[i];
            } else if (a[i] == el1) {
                c1++;
            } else if (a[i] == el2) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        int ct1 = 0;
        int ct2 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == el1) ct1++;
            if (a[i] == el2) ct2++;
        }

        int mini = n / 3 + 1;
        if (ct1 >= mini) list.add(el1);
        if (ct2 >= mini) list.add(el2);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 1, 1, 3, 2};
        int[] a2 = {1, 2, 1, 1, 3, 2, 2};
        int[] a3 = {3, 3, 3, 2, 2, 2};

        System.out.println(elementsGreaterThanNBy3Brute(a1));
        System.out.println(elementsGreaterThanNBy3Brute(a2));
        System.out.println(elementsGreaterThanNBy3Brute(a3));

        System.out.println("-----------------------------------------");
        System.out.println(elementsGreaterThanNBy3Better_1(a1));
        System.out.println(elementsGreaterThanNBy3Better_1(a2));
        System.out.println(elementsGreaterThanNBy3Better_1(a3));

        System.out.println("-----------------------------------------");
        System.out.println(elementsGreaterThanNBy3Better_2(a1));
        System.out.println(elementsGreaterThanNBy3Better_2(a2));
        System.out.println(elementsGreaterThanNBy3Better_2(a3));

        System.out.println("-----------------------------------------");
        System.out.println(elementsGreaterThanNBy3(a1));
        System.out.println(elementsGreaterThanNBy3(a2));
        System.out.println(elementsGreaterThanNBy3(a3));
    }
}
