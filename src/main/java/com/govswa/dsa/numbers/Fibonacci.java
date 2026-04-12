package com.govswa.dsa.numbers;

public class Fibonacci {

    public static void fibonacci(int n) {
        int a = 0;
        if (n == 0) {
            System.out.println(0);
        } else {
            int b = 1, c = 0;
            System.out.print(0 + " " + 1 + " ");

            while (c <= n) {
                c = a + b;
                System.out.print(c + " ");

                a = b;
                b = c;
            }
        }
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println("Fibonacci series up to " + n + ":");
        fibonacci(n);
    }
}
