package com.css.gfg.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement : Given an array of n elements. The task is to count the total number of indices (i, j) such that arr[i] = arr[j] and i != j
 *
 * Solution : The idea is to count the frequency of each number and then find the number of pairs with equal elements.
 * Suppose, a number x appears k times at index i1, i2,….,ik.
 * Then pick any two indexes ix and iy which will be counted as 1 pair.
 * Similarly, iy and ix can also be pair.
 * So, choose nC2 is the number of pairs such that arr[i] = arr[j] = x.
 *
 * Time Complexity : O(n)
 *
 * Created by kishore on 15/2/17.
 */
public class EqualIndexPairs {

    public static void main(String[] args) {

        int a[] = new int[]{1, 1, 2, 2, 2, 2, 4, 5, 6, 7, 6};
        System.out.println(pairCount(a));
    }

    private static int pairCount(int a[]) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int value : a) {
            Integer count = countMap.get(value);
            if (count == null)
                count = 0;
            countMap.put(value, ++count);
        }

        int ans = 0;
        for (Integer count : countMap.values())
            ans += nc2(count);
        return ans;
    }

    private static int nc2(int n) {
        return fact(n) / (fact(2) * fact(n-2));
    }

    private static int fact(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }
}
