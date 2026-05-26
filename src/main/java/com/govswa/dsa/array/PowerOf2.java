package com.govswa.dsa.array;

public class PowerOf2 {

    public static boolean isPowerOf2Brute(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }

    public static boolean isPowerOf2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2Brute(1));
        System.out.println(isPowerOf2Brute(2));
        System.out.println(isPowerOf2Brute(3));
        System.out.println(isPowerOf2Brute(4));
        System.out.println(isPowerOf2Brute(5));
        System.out.println(isPowerOf2Brute(8));
        System.out.println(isPowerOf2Brute(10));

        System.out.println("-------------------------------");
        System.out.println(isPowerOf2(1));
        System.out.println(isPowerOf2(2));
        System.out.println(isPowerOf2(3));
        System.out.println(isPowerOf2(4));
        System.out.println(isPowerOf2(5));
        System.out.println(isPowerOf2(8));
        System.out.println(isPowerOf2(10));

    }
}
