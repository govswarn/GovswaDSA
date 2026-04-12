package com.govswa.dsa.string;

public class Palindrome {

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "madam";
        System.out.println(isPalindrome(s));

        String s2 = "hello";
        System.out.println(isPalindrome(s2));
    }
}
