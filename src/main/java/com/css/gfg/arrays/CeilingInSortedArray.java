package com.css.gfg.arrays;

/**
    Problem Statement :
     Ceiling in a sorted array

   Explanation :
     Given a sorted array and a value x,
     the ceiling of x is the smallest element in array greater than or equal to x,
      Assume than the array is sorted in non-decreasing order.
     Write efficient functions to find ceiling of x.

   Example :
     For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
     For x = 0:   ceil  = 1
     For x = 1:   ceil  = 1
     For x = 5:   ceil  = 8
     For x = 20:  ceil doesn't exist in array

 * @author Kishore Routhu on 3/7/17 8:53 PM.
 */
public class CeilingInSortedArray {

    //Driver code
    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 8, 10, 10, 12, 19};
        int n = a.length;
        int k = 5;
        int p = ceilSearch(a, 0, n - 1, k);
        if(p == -1)
            System.out.printf("Ceil of %d doesn't exist in array ", k);
        else
            System.out.printf("Ceil of %d is %d", k, a[p]);


    }

    private static int ceilSearch(int a[], int l, int r, int k) {


        if (k <= a[l])
            return l;

        if (k > a[r])
            return -1;


        int m = (l +  r) >> 1;

        if (a[m] == k)
            return m;

        if (a[m] < k)
            if (m+1 <= r && k <= a[m+1])
                return m+1;
            else
                return ceilSearch(a, m+1, r, k);
        else
            if (m-1 >= l && k > a[m-1])
                return m-1;
            else
                return ceilSearch(a, l, m-1, k);
    }
}
