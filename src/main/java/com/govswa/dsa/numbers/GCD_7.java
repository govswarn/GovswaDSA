package com.govswa.dsa.numbers;

public class GCD_7 {

    public static int gcdBrute(int a, int b) {
        int gcd = 1;
        for (int i = 2; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static int gcdBetter(int a, int b) {
        for (int i = Math.min(a, b); i >= 2; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) a %= b;
            else if (b > a) b %= a;
        }
        return a == 0 ? b : a;
    }

    public static void main(String[] args) {
        int a = 48;
        int b = 18;

        System.out.println(gcdBrute(a, b));

        System.out.println(gcdBetter(a, b));

        System.out.println(gcd(a, b));
    }
}
