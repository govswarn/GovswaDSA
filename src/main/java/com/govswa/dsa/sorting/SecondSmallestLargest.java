package com.govswa.dsa.sorting;

import java.util.Arrays;

public class SecondSmallestLargest {

    public static void secondSmallestLargestBrute(int[] a) {
        int n = a.length;
        if (n == 0 || n == 1) {
            System.out.println("No second smallest and largest");
            return;
        }
        Arrays.sort(a);

        int secondSmallest = -1, secondLargest = -1;
        int i = 1, j = n - 2;
        boolean foundSmallest = false, foundLargest = false;

        while (i > 0 || j < n) {
            if (!foundSmallest && a[i] != a[0]) {
                secondSmallest = a[i];
                foundSmallest = true;
            }
            if (!foundLargest && a[j] != a[n - 2]) {
                secondLargest = a[j];
                foundLargest = true;
            }
            i++;
            j--;
        }
        System.out.println("second smallest: " + secondSmallest + ", second largest: " + secondLargest);
    }


    public static void secondSmallestLargestBetter(int[] a) {
        int n = a.length;
        if (n == 0 || n == 1) {
            System.out.println("No second smallest and largest");
        }
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            smallest = Math.min(a[i], smallest);
            largest = Math.max(largest, a[i]);
        }

        for (int i = 0; i < n; i++) {
            if (a[i] < secondSmallest && a[i] != smallest) {
                secondSmallest = a[i];
            }
            if (a[i] > secondLargest && a[i] != largest) {
                secondLargest = a[i];
            }
        }
        System.out.println("second smallest: " + secondSmallest + ", second largest: " + secondLargest);
    }

    public static void secondSmallestLargest(int[] a) {
        int n = a.length;
        if (n == 0 || n == 1) {
            System.out.println("No second smallest and largest");
        }
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] < smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if (a[i] < secondSmallest && a[i] != smallest) {
                secondSmallest = a[i];
            }
            if (a[i] > largest) {
                secondLargest = largest;
                largest = a[i];
            } else if (a[i] > secondLargest && a[i] != largest) {
                secondLargest = a[i];
            }
        }
        System.out.println("second smallest: " + secondSmallest + ", second largest: " + secondLargest);
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 4, 7, 7, 5};
        secondSmallestLargestBrute(a);
        secondSmallestLargestBetter(a);
        secondSmallestLargest(a);
    }
}
