package com.css.gfg.arrays;

import java.util.*;

/**
 * Problem Statement : Given an array of integers, print the number of pairs in the array that form an amicable pair.
 * Two numbers are amicable if the first is equal to the sum of divisors of the second, and if the second number is equal to the sum of divisors of the first.
 *
 *  Examples :
 *  Input  : arr[] = {220, 284, 1184, 1210, 2 , 5}
 *  Output : 2
 *  Explanation : (220, 284) and (1184, 1210) form amicable pair
 *
 * Input  : arr[] = {2620, 2924, 5020, 5564, 6232, 6368}
 *
 * Output : 3
 * Explanation : (2620, 2924), (5020, 5564) and (6232, 6368)forms amicable pair
 *
 * An efficient solution is be to keep the numbers stored in a map and for every number we find the sum of its proper divisor
 * and check if that’s also present in the array. If it is present, we can check if they form an amicable pair or not.
 *
 * Created by kishore on 15/2/17.
 */
public class AmicableNumber {

    public static void main(String[] args) {
        //int arr[] = new int[]{220, 284, 1184, 1210, 2 , 5};
        int arr[] = new int[]{2620, 2924, 5020, 5564, 6232, 6368};
        System.out.println(pairCount(arr));
    }


    private static int pairCount(int a[]) {
        int n = a.length;
        Set<Integer> set = new HashSet<Integer>(n);
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        int ans = 0;
        for (int value : set) {
            int sum = sumOfDiv(value);
            if (set.contains(sum)) {
                if(isAmicable(value, sum))
                    ans++;
            }
        }

        return ans/2;
    }


    private static boolean isAmicable(int a, int b) {
        return sumOfDiv(a) == b && a == sumOfDiv(b);
    }

    private static int sumOfDiv(int x) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) {
                sum += i;

                //for handling perfect squares
                if (x/i != i)
                    sum += x/i;
            }
        }
        return sum;
    }

}
