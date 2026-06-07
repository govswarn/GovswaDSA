package com.govswa.dsa.array;

public class MaxProductSubarray {

    public static int maxProductSubarrayBrute(int[] a) {
        int maxProduct = Integer.MIN_VALUE;
        int product;
        for (int i = 0; i < a.length; i++) {
            product = 1;
            for (int j = i; j < a.length; j++) {
                product *= a[j];
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }

    public static int maxProductSubarray(int[] a) {
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) prefix = 1;
            if (a[n - 1 - i] == 0) suffix = 1;
            prefix *= a[i];
            suffix *= a[n - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5, 0};
        int[] a2 = {1, 2, -3, 0, -4, -5};
        int[] a3 = {2, 3, -2, 4};

        System.out.println(maxProductSubarrayBrute(a1));
        System.out.println(maxProductSubarrayBrute(a2));
        System.out.println(maxProductSubarrayBrute(a3));

        System.out.println("------------------------------------------");
        System.out.println(maxProductSubarray(a1));
        System.out.println(maxProductSubarray(a2));
        System.out.println(maxProductSubarray(a3));
    }
}
