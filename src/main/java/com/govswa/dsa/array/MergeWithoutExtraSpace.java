package com.govswa.dsa.array;

import java.util.Arrays;
import java.util.function.Consumer;

public class MergeWithoutExtraSpace {

    public static void mergeBrute(int[] a1, int[] a2) {
        int n1 = a1.length, n2 = a2.length;
        int[] a = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (a1[i] <= a2[j]) {
                a[k++] = a1[i++];
            } else {
                a[k++] = a2[j++];
            }
        }
        while (i < n1) {
            a[k++] = a1[i++];
        }
        while (j < n2) {
            a[k++] = a2[j++];
        }
        for (int p = 0; p < n1; p++) {
            a1[p] = a[p];
        }
        for (int p = 0; p < n2; p++) {
            a2[p] = a[n1 + p];
        }
    }

    public static void merge_1(int[] a1, int[] a2) {
        int i = a1.length - 1, j = 0;
        while (i >= 0 && j < a2.length) {
            if (a1[i] > a2[j]) {
                int temp = a1[i];
                a1[i] = a2[j];
                a2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
    }

    public static void merge_2(int[] a1, int[] a2) {
        int n1 = a1.length, n2 = a2.length;
        int len = n1 + n2;
        int gap = len / 2 + len % 2;
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < n1 && right >= n1) {
                    swap(a1, a2, left, right - n1);
                } else if (left >= n1) {
                    swap(a2, a2, left - n1, right - n1);
                } else {
                    swap(a1, a1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = gap / 2 + gap % 2;
        }

    }

    public static void swap(int[] a1, int[] a2, int i, int j) {
        if (a1[i] > a2[j]) {
            int temp = a1[i];
            a1[i] = a2[j];
            a2[j] = temp;
        }
    }

    public static void print(int[] a1, int[] a2) {
        for (int x : a1) {
            System.out.print(x + " ");
        }
        for (int x : a2) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7, 8, 11};
        int[] a2 = {0, 2, 6, 7, 8, 9, 12};
        mergeBrute(a1, a2);
        print(a1, a2);

        System.out.println("\n---------------------------");
        a1 = new int[]{1, 3, 5, 7, 8, 11};
        a2 = new int[]{0, 2, 6, 7, 8, 9, 12};
        merge_1(a1, a2);
        print(a1, a2);

        System.out.println("\n---------------------------");
        a1 = new int[]{1, 3, 5, 7, 8, 11};
        a2 = new int[]{0, 2, 6, 7, 8, 9, 12};
        merge_2(a1, a2);
        print(a1, a2);

    }
}
