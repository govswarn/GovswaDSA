package com.govswa.dsa.numbers;

public class CountDigits {

    public static int countDigits(int n) {
        int c = 0;
        while (n > 0) {
            c++;
            n /= 10;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println(countDigits(n));
    }
}
