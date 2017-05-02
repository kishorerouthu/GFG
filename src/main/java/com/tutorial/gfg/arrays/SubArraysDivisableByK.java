package com.tutorial.gfg.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kishore on 20/2/17.
 *
 * Problem Statement :
 * Count all sub-arrays having sum divisible by k
 * You are given an array of positive and/or negative integers and a value K .
 * The task is to find count of all sub-arrays whose sum is divisible by K?
 *
 * Examples:
 *
 * Input  : arr[] = {4, 5, 0, -2, -3, 1},
 * K = 5
 * Output : 7
 // there are 7 sub-arrays whose is divisible by K
 // {4, 5, 0, -2, -3, 1}
 // {5}
 // {5, 0}
 // {5, 0, -2, -3}
 // {0}
 // {0, -2, -3}
 // {-2, -3}
 *
 */
public class SubArraysDivisableByK {

    public static void main(String[] args) {
        int arr[] = new int[]{4, 5, 0, -2, -3, 1};
        int k = 5;
        int subArrays = findCountOfSubArrays(arr, 6, k);
        System.out.println(subArrays);
    }


    //Naive approach. Time complexity O(n^2).
    private static int findSubArrays(int a[], int n, int k) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum % k == 0)
                    count++;
            }
        }
        return count;
    }

    /**
     * An efficient solution is based on below observation.

     * Let there be a subarray (i, j) whose sum is divisible by k
     *  sum(i,j) = sum(0,j) - sum(0,i-1)
     * Sum for any subarray can be written as q*k + rem where q
     * is a quotient and rem is remainder
     * Thus,
     *    sum(i,j) = (q1 * k + rem1) - (q2 * k + rem2)
     *    sum(i,j) = (q1 - q2)k + rem1-rem2
     *
     * We see, for sum(i,j) i.e. for sum of any subarray to be
     * divisible by k, the RHS should also be divisible by k.
     * (q1 - q2)k is obviously divisible by k, for (rem1-rem2) to
     * follow the same, rem1 = rem2 where
     *    rem1 = Sum of subarray (0,j) % k
     *    rem2 = Sum of subarray (0,i-1) % k
     * So if any sub-array sum from index i’th to j’th is divisible by k then we can saya[0]+…a[i-1] (mod k) = a[0]+…+a[j] (mod k)
     *
     * The above explanation is provided by Ekta Goel.
     *
     * So we need to find such a pair of indices (i, j) that they satisfy the above condition. Here is the algorithm :
     *
     * Make an auxiliary array of size k as Mod[k] .
     * This array holds the count of each remainder we are getting after dividing cumulative sum till any index in arr[].
     * Now start calculating cumulative sum and simultaneously take it’s mod with K ,
     * whichever remainder we get increment count by 1 for remainder as index in Mod[] auxiliary array. Sub-array by each pair of positions with same value * of ( cumSum % k) constitute a continuous range whose sum is divisible by K.
     * Now traverse Mod[] auxiliary array , for any Mod[i] > 1 we can choose any to pair of indices for
     * sub-array by (Mod[i]*(Mod[i] – 1))/2 number of ways .
     * Do the same for all remainders < k and sum up the result that will be the number all possible sub-arrays divisible by K.
     */

    private static int findCountOfSubArrays(int a[], int n, int k) {

        int mod[] = new int[k];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            mod[((sum%k)+k)%k]++;
        }

        int result = 0;

        for (int i = 0; i < k; i++) {
            if(mod[i] > 1)
                result += (mod[i]*(mod[i]-1))/2;
        }

        result += mod[0];

        return result;

    }

}
