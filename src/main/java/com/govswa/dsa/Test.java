package com.govswa.dsa;

class Test {

    public static int[] findStartEndForGivenKey(int[] a, int key) {
        int start = -1;
        int end = -1;
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            if (a[i] == key && start == -1) {
                start = i;
            }
            if (a[j] == key && end == -1) {
                end = j;
            }
            i++;
            j--;
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] ans = findStartEndForGivenKey(new int[]{5, 7, 7, 8, 8, 8, 10}, 8);
        System.out.print("startIndex: " + ans[0] + ", endIndex: " + ans[1]);

        System.out.println("\n-------------------------");
        int[] ans1 = findStartEndForGivenKey(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.print("startIndex: " + ans1[0] + ", endIndex: " + ans1[1]);

        System.out.println("\n-------------------------");
        int[] ans2 = findStartEndForGivenKey(new int[]{}, 0);
        System.out.print("startIndex: " + ans2[0] + ", endIndex: " + ans2[1]);
    }
}
