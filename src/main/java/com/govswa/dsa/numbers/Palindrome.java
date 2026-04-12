package com.govswa.dsa.numbers;

public class Palindrome {

    public static boolean isPalindrome(int n){
        return Reverse.reverse(n) == n;
    }

    public static void main(String[] args) {
        int n = 12321;
        System.out.println(isPalindrome(n));

        int n2 = 12345;
        System.out.println(isPalindrome(n2));
    }
}
