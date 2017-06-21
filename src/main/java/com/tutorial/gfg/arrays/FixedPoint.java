package com.tutorial.gfg.arrays;

/**
 * Created by Kishore Routhu on 19/6/17 8:28 PM.
 *
 * Given an array of n distinct integers sorted in ascending order,
 * write a function that returns a Fixed Point in the array,
 * if there is any Fixed Point present in array, else returns -1. Fixed Point in an array is an index i such that arr[i] is equal to i.
 * Note that integers in array can be negative.
 *
 * Examples:
 *
 * Input: arr[] = {-10, -5, 0, 3, 7}
 * Output: 3  // arr[3] == 3
 *
 * Input: arr[] = {0, 2, 5, 8, 17}
 * Output: 0  // arr[0] == 0
 *
 *
 * Input: arr[] = {-10, -5, 3, 4, 7, 9}
 * Output: -1  // No Fixed Point
 *
 */
public class FixedPoint {

    public static void main(String[] args) {
        int a[] = new int[]{-10, -5, 3, 4, 7, 9};
        int n = a.length;
        int fe = findFixedPointBSearch(a, n);
        System.out.println(fe);
    }

    /*
        Method 1 : Linear search
        Time Complexity : O(n)
     */
    private static int findFixedPoint(int a[], int n) {
        int fe = -1;
        for (int i = 0; i < n; i++) {
            if (i == a[i]) {
                fe = i; break;
            }
        }
        return fe;
    }

    /*
    Method 2 (Binary Search)
                First check whether middle element is Fixed Point or not.
                If it is, then return it; otherwise check whether index of middle element is greater than value at the index.
                If index is greater, then Fixed Point(s) lies on the right side of the middle point (obviously only if there is a Fixed Point).
                Else the Fixed Point(s) lies on left side.

         Time Complexity : O(logn)
     */
    private static int findFixedPointBSearch(int a[], int n) {
            int l = 0;
            int r = n-1;
            while (l < r) {
                int m = (l + r) >> 1;
                if (m == a[m])
                    return m;
                else if (a[m] > m)
                    r = m-1;
                else
                    l = m+1;
            }
            return -1;
    }
}
