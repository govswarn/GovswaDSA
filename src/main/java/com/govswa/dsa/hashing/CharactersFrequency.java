package com.govswa.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public class CharactersFrequency {

    private static final int[] hash = new int[256];

    public static void frequency_1(String s) {
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                System.out.println((char) i + " -> " + hash[i]);
            }
        }
    }

    private static final int[] hashAlpha = new int[26]; 
    //a-z --> 97-122, 0 - a, 1 - b, 2 - c...

    public static void frequency_2(String s) {
        for (int i = 0; i < s.length(); i++) {
            hashAlpha[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < hashAlpha.length; i++) {
            if (hashAlpha[i] != 0) {
                System.out.println((char) (i + 97) + " -> " + hashAlpha[i]);
            }
        }
    }

    //insertion - o(logN), fetching - o(logN) in worst case, using linked list into a balanced Red-Black Tree
    public static void frequency(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : hash.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String s = "igghdSHKf8447788445";

        frequency_1(s);
        System.out.println("---------------------");
        frequency_2("abbccadadd");

        System.out.println("---------------------");
        frequency("abbccadadd");
    }
}
