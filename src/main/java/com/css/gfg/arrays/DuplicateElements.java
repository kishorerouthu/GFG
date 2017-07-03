package com.css.gfg.arrays;

/**
 Problem Statement :

 Find duplicates in O(n) time and O(1) extra space

 Explanation :
 Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times.
 Find these repeating numbers in O(n) and using only constant memory space.

 Example :
 Let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.

 *
 * @author Kishore Routhu on 3/7/17 1:03 PM.
 */
public class DuplicateElements {

    //Driver Code
    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 1, 3, 6, 6};
        int n = 7;
        printDuplicates(a, n);
    }

    /*
    Method 1 (Use array elements as index)
    This method assumes that all the numbers in array are positive and
    marking elements negative and finding the repeated negatives.

    Traverse the array. Do following for every index i of A[].
    1) Check for sign of A[abs(A[i])]
    2) If positive then it negative by   A[abs(A[i])]=-A[abs(A[i])];
    3) Else  // i.e., A[abs(A[i])] is negative element (ith element of list) is a repetition

    Example: A[] =  {1, 1, 2, 3, 2}

    For i=0;
    Check sign of A[abs(A[0])] which is A[1].  A[1] is positive, so make it negative.
    Array now becomes {1, -1, 2, 3, 2}

    i=1;
    Check sign of A[abs(A[1])] which is A[1].  A[1] is negative, so A[1] is a repetition.

    i=2;
    Check sign of A[abs(A[2])] which is A[2].  A[2] is  positive, so make it negative. '
    Array now becomes {1, -1, -2, 3, 2}

    i=3;
    Check sign of A[abs(A[3])] which is A[3].  A[3] is  positive, so make it negative.
    Array now becomes {1, -1, -2, -3, 2}

    i=4;
    Check sign of A[abs(A[4])] which is A[2].  A[2] is negative, so A[4] is a repetition.
    */
    private static void printDuplicates(int a[], int n) {
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(a[i]);
            if (a[abs] >= 0)
                a[abs] = -a[abs];
            else
                System.out.printf("%3d" , Math.abs(abs));
        }
    }
}
