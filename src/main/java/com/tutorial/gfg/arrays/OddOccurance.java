package com.tutorial.gfg.arrays;

/**
 * Created by Kishore Routhu on 14/6/17 7:38 PM.
 *
 * Given an array of positive integers.
 * All numbers occur even number of times except one number which occurs odd number of times.
 * Find the number in O(n) time & constant space.
 */
public class OddOccurance {

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 2, 3, 1, 3};
        int n = a.length;
        int result = findOddOccuranceNumber(a, n);
        System.out.println(result);
    }

    /*
        By taking XOR of all numbers we will, result will be odd-occurance number
     */
    private static int findOddOccuranceNumber(int a[], int n) {
        int res = a[0];
        for (int i = 1; i < n; i++)
            res ^= a[i];

        return res;
    }
}


