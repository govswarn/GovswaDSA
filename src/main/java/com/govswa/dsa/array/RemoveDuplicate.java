package com.govswa.dsa.array;

public class RemoveDuplicate {

    public static void removeDuplicateBrute(int[] a) {
        int[] temp = new int[a.length];
        int k = 0;
        temp[k++] = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                temp[k++] = a[i];
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    public static int removeDuplicate(int[] a) {
        int i = 0;
        for (int j = 1; j < a.length; j++) {
            if (a[j] != a[i]) {
                i++;
                a[i] = a[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 2, 3, 4, 4, 5};
        int[] a2 = {1, 1, 1, 1, 1, 1, 1, 1};

        removeDuplicateBrute(a1);
        System.out.println();
        removeDuplicateBrute(a2);

        System.out.println("\n-------------------------------------");
        int n1 = removeDuplicate(a1);
        for (int i = 0; i < n1; i++) {
            System.out.print(a1[i] + " ");
        }
        System.out.println();
        int n2 = removeDuplicate(a2);
        for (int i = 0; i < n2; i++) {
            System.out.print(a2[i] + " ");
        }
    }
}