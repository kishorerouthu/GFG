package com.css.gfg.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Problem Statement :
 * Break an array into maximum number of sub-arrays such that their averages are same
 * Given an integer array, the task is to divide the array into maximum number of sub-arrays
 * such that averages of all subarrays is same. If it is not possible to divide, then print “Not possible”.
 *
 *  Example :
 *  Input : arr[] = {1, 5, 7, 2, 0};
 *  Output : (0  1)
 *           (2  4)
 *  Subarrays arr[0..1] and arr[2..4] have same average.
 *
 *  Input  : arr[] = {4, 6, 2, 4, 8, 0, 6, 2};
 *  Output : (0, 0)
 *           (1, 2)
 *           (3, 3)
 *           (4, 5)
 *           (6, 7)
 *
 * Input : arr[] = {3, 3, 3};
 * Output : (0, 0)
 *          (1, 1)
 *          (2, 2)
 *
 * Input  : arr[] = {4, 3, 5, 9, 11};
 * Output : Not possible
 *
 * The idea is based on the fact that if an array can be divided in subarrays of same average,
 * then anerage of all these subarrays must be same as overall average.
 *
 * 1) Find average of whole array.
 * 2) Traverse array again and keep track of average of current subarray.
 * As soon as the average becomes same as overall overall average, print current subarray and begin new subarray.
 *
 * This solution divides to maximum number of subarrays because we begin a new subarray as soon as we find average same as overall average.
 *
 * Created by kishore on 15/2/17.
 */
public class MaximumNumSubArrays {

    public static void main(String[] args) {
        int a[] = new int[]{4, 6, 2, 4, 8, 0, 6, 2};
        printSubArrays(a);
    }


private static void printSubArrays(int a[]) {

    int n = a.length;
    int sum = 0;
    for (int value : a) {
        sum += value;
    }

    List<Integer> sub = new ArrayList<Integer>();
    int previous_index = -1;
    int current_sum = 0;
    for (int i = 0; i < n; i++) {

        current_sum += a[i];

        //If the current point is array break point
        if (sum * (i - previous_index) == current_sum * n) {
            current_sum = 0;
            previous_index = i;

            //Add current array break point
            sub.add(previous_index);
        }
    }

    System.out.println("(0, " + sub.get(0) + ")");
    for (int i = 1; i < sub.size(); i++) {
        System.out.println("(" + (sub.get(i - 1) + 1) + "," + sub.get(i) + ")");
    }
}

}
