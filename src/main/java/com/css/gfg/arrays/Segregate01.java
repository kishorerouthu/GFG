package com.css.gfg.arrays;

/**
 * @author Kishore Routhu on 22/6/17 8:57 PM.
 *
 * Problem Statement : Segregate 0s and 1s in an array
 *
 * Explanation : You are given an array of 0s and 1s in random order.
 * Segregate 0s on left side and 1s on right side of the array. Traverse array only once.
 *
 * Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
 * Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 */

public class Segregate01 {

    public static void main(String[] args) {
        int a[] = new int[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int n = a.length;
        sort2(a, n);
        print(a);
    }

    private static void print(int a[]) {
        for (int e : a)
            System.out.printf("%d ", e);
    }

    /*
        Method 1: (Count 0s or 1s)
        1) Count the number of 0s in array, let be C
        2) Then place fill all first C with 0 and remaining n-c with 1 in arrays

        Time Complexity : O(2n)

     */
    private static void sort(int a[], int n) {

        int c = 0;
        for (int i = 0; i < n; i++)
            if (a[i] == 0)
                c++;

        for (int j = 0; j < c; j++)
            a[j] = 0;

        for (int k = c; k < n; k++)
            a[k] = 1;
    }

    /*
        Method 2 : Using two indexes

         Maintain two indexes, initialize first index left as 0 and second index right as n-1

         Do the following while left < right
         a) Keep incrementing index left while there 0s at it
         b) Keep decrementing index right while there 1s at it
         c) If left < right then swap a[left] with a[right]

         Time Complexity : O(n):
     */
    private static void sort2(int a[], int n) {

        /* Initialize left and right indexes */
        int left = 0;
        int right = n-1;

        while (left < right) {

             /* Increment left index while we see 0 at left */
            while (a[left] == 0 && left < right)
                left++;

             /* Decrement right index while we see 1 at right */
            while (a[right] == 1 && left < right)
                right--;

            if (left < right) {
                int tmp = a[left];
                a[left] = a[right];
                a[right] = tmp;
            }

        }
    }
}
