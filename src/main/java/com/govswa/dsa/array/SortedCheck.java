package com.govswa.dsa.array;

public class SortedCheck {

    public boolean isSortedAsc(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        SortedCheck sortedCheck = new SortedCheck();
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {5, 4, 3, 2, 1};
        int[] c = {1, 3, 2, 4, 5};

        System.out.println("Array a is sorted: " + sortedCheck.isSortedAsc(a));
        System.out.println("Array b is sorted: " + sortedCheck.isSortedAsc(b));
        System.out.println("Array c is sorted: " + sortedCheck.isSortedAsc(c));
    }
}
