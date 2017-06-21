package com.tutorial.gfg.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kishore Routhu on 14/6/17 12:14 PM.
 *
 * Majority Element
 * Majority Element: A majority element in an array A[] of size n is an element
 * that appears more than n/2 times (and hence there is at most one such element).
 *
 * Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as follows:
 *
 * I/P : 3 3 4 2 4 4 2 4 4
 * O/P : 4
 *
 * I/P : 3 3 4 2 4 4 2 4
 * O/P : NONE
 */

public class MajorityElement {
    public static void main(String[] args) {
        //int a[] = new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4};
        int a[] = new int[]{3, 3, 4, 2, 4, 4, 2, 4};
        int n = 8;
       // printMajorityElement(a, n);

        //Is Majority Element
        int arr[] = {1, 2, 3, 3, 3, 3, 10};
        int n1 = arr.length;
        int x = 3;
        System.out.println(isMajorityElementBSearch(arr, n1, x));
    }

    /*
        Method 1 :
     */
    public static void printMajorityElement(int a[], int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            Integer count = map.get(a[i]);
            count = (count == null) ? 1 : count + 1;
            if (count > n/2) {
                System.out.println(a[i]);
                return;
            }
            else
                map.put(a[i], count);
        }
        System.out.println("NONE");
    }

    /*
        Method 1: Is majority element using linear search
     */
    private static boolean isMajorityElement(int a[], int n, int x) {
        for (int i = 0; i < n; i++)
            if (a[i] == x)
                return a[i + n/2] == x;

        return false;
    }

    /*
        Method 2 : Using binary search

     */
    private static boolean isMajorityElementBSearch(int a[], int n, int x) {

        int i = binarySearch(a, 0, n-1, x);

        if (i == -1)
            return false;

        return ((i + n/2 <= (n-1)) && (a[i + n/2] == x));

    }

    private static int binarySearch(int a[], int l, int r, int x) {

        if (l <= r) {
            int m = (l+r) >> 1;

            if (m == 0 || (x > a[m-1] && a[m] == x))
                return m;
            else if (x < a[m])
                return binarySearch(a, m+1, r, x);

            return binarySearch(a, l, m-1, x);
        }

        return -1;
    }
}
