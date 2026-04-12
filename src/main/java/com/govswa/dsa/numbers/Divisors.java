package com.govswa.dsa.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Divisors {

    public static List<Integer> divisorsBrute(int n) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    public static List<Integer> divisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        Collections.sort(divisors);
        return divisors;
    }

    public static void main(String[] args) {
        int n = 36;

        System.out.println(divisorsBrute(n));

        System.out.println(divisors(n));
    }
}
