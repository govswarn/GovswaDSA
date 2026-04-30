package com.govswa.dsa.array;

import java.util.Arrays;
import java.util.function.Function;

public class Largest {

    public static int largestBrute(int[] a) {
        Arrays.sort(a);
        return a[a.length - 1];
    }

    public static int largest(int[] a) {
        int largest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > largest) {
                largest = a[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        Largest.test(Largest::largestBrute);
        Largest.test(Largest::largest);
    }

    public static void test(Function<int[], Integer> largetFunction) {
        int[][] aa = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}};
        for (int i = 0; i < aa.length; i++) {
            int[] a = aa[i].clone();
            int largest = largetFunction.apply(a);
            System.out.println("largest: " + largest);
        }
    }
}
