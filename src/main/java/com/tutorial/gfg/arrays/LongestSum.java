package com.tutorial.gfg.arrays;

/**
 * Created by Kishore Routhu on 14/6/17 7:49 PM.
 *
 * Write a programm to find the sum of contiguous subarray within a
 * one-dimensional array of numbers which has the largest sum.
 *
 * Example : -2 -3 4 -1 -2 1 5 -3
 *
 *           LCS (4, -1, -2, 1, 5) = 7
 *
 *
 */
public class LongestSum {

    public static void main(String[] args) {
        int a[] = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int n = 8;
        int lsm = lsm2(a, n);
        System.out.println(lsm);
    }


    /*
        Method 1:
            Take 2 fields max_so_far which tells max up-to the index
                          max_ending_here which tells max that ends at index

        Time Complexity : O(n)

        NOTE : This method fails when array contains all negative numbers
     */
    private static int lsm(int a[], int n) {
        int max_so_far = 0;
        int max_ending_here = 0;
        for (int i = 0; i < n; i++) {
            max_ending_here += a[i];

            if (max_ending_here < 0)
                max_ending_here = 0;
            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;

        }

        return max_so_far;
    }

    /*
        Method 2
     */
    private static int lsm2(int a[], int n) {
        int curr_max = a[0];
        int max_so_far = a[0];
        for (int i = 0; i < n; i++) {
                curr_max = Math.max(a[i], curr_max + a[i]);
                max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
}
