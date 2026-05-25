package com.govswa.dsa.array;

public class SetMatrixZero {

    public static void setMatrixZeroBrute(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    markRow(a, m, i);
                    markCol(a, n, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == -1) {
                    a[i][j] = 0;
                }
            }
        }
    }

    public static void setMatrixZeroBetter(int[][] a) {
        int n = a.length, m = a[0].length;
        int[] markRow = new int[n];
        int[] markCol = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    markRow[i] = 1;
                    markCol[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (markRow[i] == 1 || markCol[j] == 1) {
                    a[i][j] = 0;
                }
            }
        }
    }

    public static void setMatrixZero(int[][] a) {
        int col0 = 1;
        int n = a.length, m = a[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    a[i][0] = 0;
                    if (j != 0) {
                        a[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i][0] == 0 || a[0][j] == 0) {
                    a[i][j] = 0;
                }
            }
        }
        if (a[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                a[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                a[i][0] = 0;
            }
        }
    }

    private static void markRow(int[][] a, int m, int i) {
        for (int k = 0; k < m; k++) {
            if (a[i][k] != 0) {
                a[i][k] = -1;
            }
        }
    }

    private static void markCol(int[][] a, int n, int j) {
        for (int k = 0; k < n; k++) {
            if (a[k][j] != 0) {
                a[k][j] = -1;
            }
        }
    }


    private static void print(int[][] a) {
        for (int[] row : a) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] a1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        int[][] a2 = {
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}};
        int[][] a3 = {
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1}};
        setMatrixZeroBrute(a1);
        setMatrixZeroBrute(a2);
        setMatrixZeroBrute(a3);
        print(a1);
        System.out.println();
        print(a2);
        System.out.println();
        print(a3);
        System.out.println("-------------------------------------");
        a1 = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        a2 = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}};
        a3 = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1}};
        setMatrixZeroBetter(a1);
        setMatrixZeroBetter(a2);
        setMatrixZeroBetter(a3);
        print(a1);
        System.out.println();
        print(a2);
        System.out.println();
        print(a3);
        System.out.println("-------------------------------------");
        a1 = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        a2 = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}};
        a3 = new int[][]{
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1}};
        setMatrixZero(a1);
        setMatrixZero(a2);
        setMatrixZero(a3);
        print(a1);
        System.out.println();
        print(a2);
        System.out.println();
        print(a3);
    }

}
