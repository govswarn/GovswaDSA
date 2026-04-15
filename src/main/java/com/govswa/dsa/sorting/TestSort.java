package com.govswa.dsa.sorting;

import com.govswa.dsa.array.PrintArray;

import java.util.function.Consumer;

public class TestSort {

    //“A function that takes int[] and returns nothing”
    public static void testSort(Consumer<int[]> sortFunction) {
        int[] a1 = {13, 46, 24, 52, 20, 9};
        int[] a2 = {5, 4, 3, 2, 1};
        int[] a3 = {1, 2, 3, 4, 5};

        int[][] testCases = {a1, a2, a3};

        for (int[] test : testCases) {
            int[] a = test.clone(); // avoid modifying original

            sortFunction.accept(a); //calling methods

            PrintArray.print(a);
            System.out.println("\n-------------------");
        }
    }
}
