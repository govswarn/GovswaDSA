package com.govswa.dsa.numbers;

public class Armstrong_4 {

    public static boolean isArmstrong(int n) {
        int arm = 0;
        int num = n;
        while (num > 0) {
            int x = num % 10;
            arm += (x * x * x);
            num /= 10;
        }
        return arm == n;
    }

    public static void main(String[] args) {
        int n = 153;
        System.out.println(isArmstrong(n));

        int n1 = 371;
        System.out.println(isArmstrong(n1));

        int n3 = 123;
        System.out.println(isArmstrong(n3));
    }
}
