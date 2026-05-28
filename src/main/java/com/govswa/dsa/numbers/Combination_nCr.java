package com.govswa.dsa.numbers;

public class Combination_nCr {

    public static int nCrBrute(int n, int r) {
        return Factorial.factorial(n) / (Factorial.factorial(r) * Factorial.factorial(n - r));
    }

    public static int nCr(int n, int r) {
        if (r > n) return 0;

        int res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(nCrBrute(5, 0));
        System.out.println(nCrBrute(5, 1));
        System.out.println(nCrBrute(5, 5));
        System.out.println(nCrBrute(5, 4));
        System.out.println(nCrBrute(5, 3));

        System.out.println("-----------------------------");
        System.out.println(nCr(5, 0));
        System.out.println(nCr(5, 1));
        System.out.println(nCr(5, 5));
        System.out.println(nCr(5, 4));
        System.out.println(nCr(5, 3));
    }
}
