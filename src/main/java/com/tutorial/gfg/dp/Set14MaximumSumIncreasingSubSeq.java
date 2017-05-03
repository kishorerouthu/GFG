package com.tutorial.gfg.dp;

/**
 * Created by kishore on 3/5/17.
   Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence of the given array such that the intgers in the subsequence are sorted in increasing order.

   For example, if input is {1, 101, 2, 3, 100, 4, 5},
   then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10

 * Time Complexity: O(n^2)
 */
public class Set14MaximumSumIncreasingSubSeq {

    public static void main(String[] args) {
        int a[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int sum = maxSumIS(a, a.length);
        System.out.println(sum);
        /*
            a - [1, 101, 2, 3, 100, 4, 5]
            msis - [1, 102, 3, 6, 106, 10, 15]
         */
    }

    private static int maxSumIS(int a[], int n) {

        int msis[] = new int[n];

        for (int i = 0; i < n; i++)
            msis[i] = a[i];

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (a[i] > a[j] && msis[i] < msis[j] + a[i])
                    msis[i] = msis[j] + a[i];

        int max = Integer.MIN_VALUE;
        for (int k = 0; k < n; k++)
            max = Math.max(max, msis[k]);

        return max;
    }
}

