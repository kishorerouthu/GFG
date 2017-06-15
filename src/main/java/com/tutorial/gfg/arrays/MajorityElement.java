package com.tutorial.gfg.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kishore Routhu on 14/6/17 12:14 PM.
 *
 * Majority Element
 * Majority Element: A majority element in an array A[] of size n is an element
 * that appears more than n/2 times (and hence there is at most one such element).
 *
 * Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as follows:
 *
 * I/P : 3 3 4 2 4 4 2 4 4
 * O/P : 4
 *
 * I/P : 3 3 4 2 4 4 2 4
 * O/P : NONE
 */

public class MajorityElement {
    public static void main(String[] args) {
        //int a[] = new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4};
        int a[] = new int[]{3, 3, 4, 2, 4, 4, 2, 4};
        int n = 8;
        printMajorityElement(a, n);
    }

    /*
        Method 1 :
     */
    public static void printMajorityElement(int a[], int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            Integer count = map.get(a[i]);
            count = (count == null) ? 1 : count + 1;
            if (count > n/2) {
                System.out.println(a[i]);
                return;
            }
            else
                map.put(a[i], count);
        }
        System.out.println("NONE");
    }
}
