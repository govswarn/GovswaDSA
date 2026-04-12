package com.govswa.dsa.numbers;

public class Prime {

    public static boolean isPrimeBrute(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(isPrimeBrute(n));

        int n2 = 15;
        System.out.println(isPrimeBrute(n2));

        int n3 = 37;
        System.out.println(isPrime(n3));
    }
}
