package com.css.gfg.arrays;

/**
 * Created by Kishore Routhu on 10/6/17 10:37 AM.
 *
 * Problem Statement :
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
 *
 */
public class FindingMissingNumber {

    public static void main(String[] args) {
            int a[] = new int[]{1, 2, 4, 5, 6};
            //int miss = findMissingNumber(a, 5);
            int miss = findMissingNumberXOR(a, 5);
            System.out.println(miss);
    }

    /*
        Method 1 :
        1. Get the sum of numbers total = n * (n + 1) / 2
        2. Subtract all the numbers from sum and you will get the missing number
        Time Complexity : O(n)
     */
    private static int findMissingNumber(int a[], int n) {
         int sum = ((n+1) * (n+2)) / 2;
         for (int i = 0; i < n; i++)
             sum -= a[i];

         return sum;
     }

     /*
        Method 2:
        1. XOR all the array elements, let the result be x1
        2. XOR all numbers from 1 to n, let the result be x2
        3. XOR of x1 and x2 gives the missing number
      */
     private static int findMissingNumberXOR(int a[], int n) {

         int x1 = a[0];
         for (int i  = 1; i < n; i++)
             x1 ^= a[i];

         int x2 = 1;
         for (int i = 2; i <= n+1; i++)
             x2 ^= i;

         return x1 ^ x2;

     }


}
