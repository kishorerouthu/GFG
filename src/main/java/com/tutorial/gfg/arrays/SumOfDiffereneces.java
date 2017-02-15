package com.tutorial.gfg.arrays;

/**
 * Created by kishore on 30/1/17.
 *
 * Problem Statement : Sum of absolute differences of all pairs in a given array
 * Given a sorted array of distinct elements,
 * the task is to find the summation of absolute differences of all pairs in the given array.
 * Examples:
 *
 * Input : arr[] = {1, 2, 3, 4}
 * Output: 10
 * Sum of |2-1| + |3-1| + |4-1| + |3-2| + |4-2| + |4-3| = 10
 *
 * Input : arr[] = {1, 8, 9, 15, 16}
 * Output: 74
 *
 * Input : arr[] = {1, 2, 3, 4, 5, 7, 9, 11, 14}
 * Output: 188
 *
 * An efficient solution for this problem needs a simple observation.
 * Since array is sorted and elements are distinct, when we take sum of absolute difference of pairs each element
 * in the i’th position is added ‘i’ times and subtracted ‘n-1-i’ times.
 *
 * For example in {1,2,3,4} element at index 2 is arr[2] = 3 so all pairs having 3 as one element will be (1,3), (2,3) and (3,4),
 * now when we take summation of absolute difference of pairs, then for all pairs in which 3 is present as one element
 * summation will be = (3-1)+(3-2)+(4-3). We can see that 3 is added i = 2 times and subtracted n-1-i = (4-1-2) = 1 times.
 * The generalized expression for each element will be sum = sum + (i*a[i]) – (n-1-i)*a[i].
 *
 */
public class SumOfDiffereneces {

    public static void main(String[] args) {
        int a[] = new int[] {1, 2, 3, 4};
        System.out.println(sumOfDiffs(a, a.length));

        int a1[] = new int[] {1, 8, 9, 15, 16};
        System.out.println(sumOfDiffs(a1, a1.length));
    }

    private static int sumOfDiffs(int a[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + (i*a[i]) - (n-1-i) * a[i];
        }
        return  sum;
    }
}
