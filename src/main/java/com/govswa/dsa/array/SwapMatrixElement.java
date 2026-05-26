package com.govswa.dsa.array;

public class SwapMatrixElement {
    public static void swap(int[][] a, int i, int j) {
        int temp = a[i][j];
        a[i][j] = a[j][i];
        a[j][i] = temp;
    }
}
