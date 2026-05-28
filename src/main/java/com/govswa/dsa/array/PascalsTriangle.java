package com.govswa.dsa.array;

import com.govswa.dsa.numbers.Combination_nCr;

import java.util.Arrays;

public class PascalsTriangle {

    public static int elementAtRowCol(int row, int col) {
        return Combination_nCr.nCr(row - 1, col - 1);
    }

    public static int[] generateRowBrute(int row) {
        int[] res = new int[row];
        for (int c = 1; c <= row; c++) {
            res[c - 1] = elementAtRowCol(row, c);
        }
        return res;
    }

    public static int[] generateRow(int row) {
        int[] res = new int[row];
        int ans = 1;
        res[0] = ans;
        for (int c = 1; c < row; c++) {
            ans *= (row - c);
            ans /= c;
            res[c] = ans;
        }
        return res;
    }

    public static int[][] pascalsTriangle(int row) {
        int[][] pascalsTriangle = new int[row][row];
        for (int i = 1; i <= row; i++) {
            pascalsTriangle[i - 1] = generateRow(i);
        }
        return pascalsTriangle;
    }

    public static void main(String[] args) {
        int row = 6;
        int col = 6;

        System.out.println(elementAtRowCol(row, col));
        System.out.println(Arrays.toString(generateRowBrute(row)));
        System.out.println(Arrays.toString(generateRow(6)));

        System.out.println("Pascals Triangle:");
        int[][] pascalsTriangle = pascalsTriangle(6);
        for (int i = 0; i < pascalsTriangle.length; i++) {
            for (int j = 0; j < pascalsTriangle[i].length; j++) {
                System.out.print(pascalsTriangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
