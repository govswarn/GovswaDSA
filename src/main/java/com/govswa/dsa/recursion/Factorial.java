package com.govswa.dsa.recursion;

public class Factorial {

    public static int factorial(int n) {
        return n != 0 ? n * factorial(n - 1) : 1;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " is: " + factorial(n));
    }
}
