package com.css.gfg.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 Problem Statement :
 Find the two repeating elements in a given array

 Description :
 You are given an array of n+2 elements.
 All elements of the array are in range 1 to n.
 And all elements occur once except two numbers which occur twice.
 Find the two repeating numbers.

 Example :
 array = {4, 2, 4, 5, 2, 3, 1} and n = 5

 The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice.
 So the output should be 4 2.

 *
 * @author Kishore Routhu on 3/7/17 11:44 AM.
 */
public class TwoRepeatingElements {

    //Driver method
    public static void main(String[] args) {
        int a[] = new int[]{4, 2, 4, 5, 2, 3, 1};
        int n = 5;
        //printRepeated1(a, n);
        //printRepeated2(a, n);
        printRepeated3(a, n);
        printRepeated4(a, n);
    }

    /*
        Method 1
        Use two loops, for each element in the outer loop count the number of occurrences by
        comparing the element in the second loop

        Time Complexity O(n ^ 2)
     */

    private static void printRepeated1(int a[], int n) {
        for (int i = 0; i < n+2; i++)
            for (int j = i + 1; j < n+2; j++)
                if (a[i] == a[j]) {
                    System.out.println(a[i]);
                    break;
                }

    }

    /*
        Method 2 (Using count array)
        1) Take one count array with the size of n as elements limit in 1..n.
        2) For each element in the array increment the count in count array as the current element index to count array
        3) Now run loop on count array and print the index for which count >= 2.
        Example : a = [4, 2, 4, 5, 2, 3, 1]
                  count = [1, 2, 1, 3, 1] contains the number of occurrences of each element

        Time Complexity O(n)
        Space Complexity O(n)
     */
    private static void printRepeated2(int a[], int n) {
        int count[] = new int[n + 1];

        for (int i = 0; i < n+2; i ++)
            count[a[i]]++;

        for (int i = 0; i < n+1; i++)
            if (count[i] > 1)
                System.out.println(i);

    }

    /*
        Method 3 (Using 2 mathematical equations)
        1) Let the numbers which are being repeated are X and Y.
        2) We make two equations for X and Y and the simple task left is to solve the two equations.
        3) We know the sum of integers from 1 to n is n(n+1)/2 and product is n!.
        4) We calculate the sum of input array, when this sum is subtracted from n(n+1)/2, we get X + Y because X and Y are the two numbers missing from set [1..n].
        5) Similarly calculate product of input array, when this product is divided from n!, we get X*Y. Given sum and product of X and Y, we can find easily out X and Y.

         Let summation of all numbers in array be S and product be P
           X + Y = S – n(n+1)/2
           XY = P/n!

         From above two equations, we can find X - Y, using the equation X - Y = sqrt((X+Y)^2) - 4 * XY)

         For array = 4 2 4 5 2 3 1, we get S = 21 and P as 960.

        X + Y = 21 – 15 = 6
        XY = 960/5! = 8
        X – Y = sqrt((X+Y)^2 – 4*XY) = sqrt(4) = 2

        X + Y = 6
        X – Y = 2

        X = ((X + Y) + (X - Y)) / 2 = (6 + 2) / 2 = 4
        Y = ((X + Y) - (X - Y)) / 2 = (6 - 2) / 2 = 2
     */
    private static void printRepeated3(int a[], int n) {

        int sum = 0;
        int prod = 1;
        for (int i = 0; i < n+2; i++) {
            sum += a[i];
            prod *= a[i];
        }

        int xsy = sum - ((n * (n + 1)) / 2);
        int xpy = prod / fact(n);
        int xmy = (int)Math.sqrt(xsy*xsy - 4*xpy);

        int x = (xsy + xmy) / 2;
        int y = (xsy - xmy) / 2;
        System.out.println(x);
        System.out.println(y);
    }

    static Map<Integer, Integer> lookup = new HashMap();
    private static int fact(int n) {

        if (n == 1)
            return 1;

        Integer f = lookup.get(n);
        if (f == null) {
            f = n * fact(n - 1);
            lookup.put(n, f);
        }

        return f;
    }

    /*
    Method 4 (Use array elements as index)
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
    private static void printRepeated4(int a[], int n) {
        for (int i = 0; i < n+2; i ++) {
            int abs = Math.abs(a[i]);
            if (a[abs] >= 0)
                a[abs] = -a[abs];
            else
                System.out.println(Math.abs(a[abs]));

        }
    }

}
