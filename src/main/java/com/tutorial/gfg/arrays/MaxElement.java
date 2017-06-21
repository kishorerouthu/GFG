package com.tutorial.gfg.arrays;

/**
 * Created by Kishore Routhu on 19/6/17 8:39 PM.
 *
 * Find the maximum element in an array which is first increasing and then decreasing
 * Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array.
 *
 * Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
 * Output: 500
 *
 * Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
 * Output: 50
 *
 * Corner case (No decreasing part)
 * Input: arr[] = {10, 20, 30, 40, 50}
 * Output: 50
 *
 * Corner case (No increasing part)
 * Input: arr[] = {120, 100, 80, 20, 0}
 * Output: 120
 */
public class MaxElement {

    public static void main(String[] args) {
        int a[] = new int[]{1, 3, 50, 10, 9, 7, 6};
        int n = a.length;
        System.out.println(maxElementBSearch(a, 0, n));
    }

    /*
        Method1 : Linear Search
                 Time Complexity : O(n)
     */
    private static int maxElement(int a[], int n) {
        int i = 0;
        while (i<n-1 && a[i] < a[i+1]) i++;
        return a[i];
    }

    /*
        Method 2 : (Binary Search)
                 We can modify the standard Binary Search algorithm for the given type of arrays.
                    i) If the mid element is greater than both of its adjacent elements, then mid is the maximum.
                    ii) If mid element is greater than its next element and smaller than the previous element then maximum lies on left side of mid.
                        Example array: {3, 50, 10, 9, 7, 6}
                    iii) If mid element is smaller than its next element and greater than the previous element then maximum lies on right side of mid.
                        Example array: {2, 4, 6, 8, 10, 3, 1}
                Time Complexity : O(logN)
     */
    protected static int maxElementBSearch(int a[], int l, int h) {
       /*Base Case: Only one element is present h == l */
       if (l == h)
           return a[l];

       /*If only two elements are present return maximum value */
       if (h == l + 1)
           return Math.max(a[l], a[h]);

       int m = (l + h) >> 1;
       if (a[m] > a[m+1] && a[m] > a[m-1])
           return a[m];

       if (a[m] < a[m+1] && a[m] > a[m-1])
           return maxElementBSearch(a, m+1, h);
       return maxElementBSearch(a, l, m-1);
    }
}
