package com.govswa.dsa.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leaders {

    public static List<Integer> leadersBrute(int[] a) {
        boolean isLeader;
        List<Integer> leaders = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            isLeader = true;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > a[i]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                leaders.add(a[i]);
            }
        }
        return leaders;
    }

    public static List<Integer> leaders(int[] a) {
        int max = Integer.MIN_VALUE;
        List<Integer> leaders = new ArrayList<>();
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] > max) {
                max = a[i];
                leaders.add(a[i]);
            }
        }
        leaders.sort(Comparator.reverseOrder());
        return leaders;
    }

    public static void main(String[] args) {
        int[] a1 = {10, 22, 12, 3, 0, 6};
        int[] a2 = {4, 7, 1, 0};

        System.out.println(leadersBrute(a1));
        System.out.println(leadersBrute(a2));

        System.out.println("-------------------------------------");
        System.out.println(leaders(a1));
        System.out.println(leaders(a2));
    }
}
