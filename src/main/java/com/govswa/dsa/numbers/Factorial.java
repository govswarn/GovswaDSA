package com.govswa.dsa.numbers;

public class Factorial {

    public static int factorial(int n) {
        int f = 1;
        for (int i = n; i > 0; i--) {
            f *= i;
        }
        return f;
    }


    public static void main(String[] args) {
        System.out.println(factorial(0));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
        System.out.println(factorial(6));
    }
}
