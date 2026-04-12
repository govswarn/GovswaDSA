package com.govswa.dsa.recursion;

public class Sum {

    public static int sum(int n) {
        return n > 0 ? n + sum(n - 1) : 0;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Sum of first " + n + " natural numbers is: " + sum(n));
    }
}
