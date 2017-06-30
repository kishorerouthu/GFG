package com.css.gfg.arrays;

import java.util.*;

/**
 * Created by Kishore Routhu on 14/6/17 11:17 AM.
 *
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 * Write a  program that, given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x.
 */
public class SumPair {

    public static void main(String[] args) {
        int a[] = new int[]{1, 4, 45, 6, 10, -8};
        int sum = 16;
        System.out.println(isPairExistsMap(a, 6, sum));
    }


    /*
        Method 1: Using two loops of the array naive approach
        Time Complexity : O(n^2)
     */
    public static boolean isPairExists(int a[], int n, int sum) {
        for (int i = 0; i < n-1; i++) {
            int tSum = sum - a[i];
            for (int j = i+1; j < n; j++) {
                if (tSum - a[j] == 0)
                    return true;
            }
        }
        return false;
    }

    /*
        Method2 : Using sorting as following
                 1. Sort the array in increasing order
                 2. Initialize two index variables to find the candidate
                    a) Initialize first to the leftmost index: l = 0
                    b) Initialize second to the rightmost index: r = size-1
                 3. Loop while l<r
                    a) If A[l] + A[r] > sum, then r--
                    b) If A[l] + A[r] < sum, then l++
                    c) If A[l] + A[r] == sum, return true
                 4. No candidate in whole array, then return false.

        Time Complexity : Depends on the sorting algorithm used
     */
    private static boolean isPairExistsSorting(int a[], int n, int sum) {
        Arrays.sort(a);
        int l = 0;
        int r = n-1;
        while (l < r) {
            if (a[l] + a[r] == sum) {
                return true;
            } else if (a[l] + a[r] > sum) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    /*
        Method 3: Using HashMap
                1. Initialize Binary HashMap
                2. Do the following for-each element in array
                    a) If M[x-A[i]] is set then print the pair (A[i], x-A[i])
                    b) set M[A[i]]
     */
    private static boolean isPairExistsMap(int a[], int n, int sum) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (list.contains(sum - a[i]))
                return true;
            list.add(a[i]);
        }
        return false;
    }


}
