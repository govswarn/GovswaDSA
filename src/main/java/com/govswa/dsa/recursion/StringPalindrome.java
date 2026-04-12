package com.govswa.dsa.recursion;

public class StringPalindrome {

    public static boolean isPalindrome(String s, int i) {
        //crossed half of array means all half from both end compared
        if (i >= s.length() / 2) {
            return true;
        }
        if (s.charAt(i) == s.charAt(s.length() - 1 - i)) {
            return isPalindrome(s, i + 1);
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "madam";
        System.out.println(isPalindrome(s, 0));

        String s2 = "hello";
        System.out.println(isPalindrome(s2, 0));
    }
}
