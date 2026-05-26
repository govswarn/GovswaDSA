package com.govswa.dsa.array;

public class RotateMatrixBy90 {

    public static int[][] rotateBrute(int[][] a) {
        int n = a.length, m = a[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[j][n - 1 - i] = a[i][j];
            }
        }
        return ans;
    }

    public static void rotate(int[][] a) {
        TransposeMatrix.transpose(a);
        for (int i = 0; i < a.length; i++) {
            ReverseArray.reverse(a[i]);
        }
    }

    public static void main(String[] args) {
        int[][] a1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] a2 = {
                {1, 2},
                {3, 4}
        };

        int[][] ans1 = rotateBrute(a1);
        for (int i = 0; i < ans1.length; i++) {
            for (int j = 0; j < ans1[0].length; j++) {
                System.out.print(ans1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-------------------------------------");

        int[][] ans2 = rotateBrute(a2);
        for (int i = 0; i < ans2.length; i++) {
            for (int j = 0; j < ans2[0].length; j++) {
                System.out.print(ans2[i][j] + " ");
            }
            System.out.println();
        }

        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotate(a);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
