package com.govswa.dsa.array;

public class Swap {

    /*
    Integer Overflow
        If values are large, a[i] + a[j] can exceed Integer.MAX_VALUE
        This leads to incorrect results
    Same Index Case (i == j)
        When i == j, this logic breaks the value (it becomes 0)
        Always use a temporary variable:
    */
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        swap(a, 1, 3);

        PrintArray.print(a);
    }
}
