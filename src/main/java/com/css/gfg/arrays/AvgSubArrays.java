package com.css.gfg.arrays;

/**
 * Created by kishore on 29/1/17.
 *
 * Problem Statement : Given an integer array, the task is to divide an integer array into two sub-arrays to make their averages equal if possible.
 *
 * Examples :
 *
 * Input : arr[] = {1, 5, 7, 2, 0};
 * Output : (0  1) and (2  4)
 * Subarrays arr[0..1] and arr[2..4] have same average.
 *
 * Input : arr[] = {4, 3, 5, 9, 11};
 * Output : Not possible
 *
 */
public class AvgSubArrays {

    public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 7 ,2, 0};
        System.out.println("Arr1 : " + findSubarrays(arr, arr.length));

        int arr1[] = new int[] {4, 3, 5, 9, 11};
        System.out.println("Arr2 : " + findSubarrays(arr1, arr.length));
    }

    private static boolean findSubarrays(int arr[], int n) {

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        int lsum = 0;
        boolean found = false;
        for (int i = 0; i < n-1; i++) {

            lsum += arr[i];
            int rsum = sum - lsum;
            if (lsum * (n-i-1) == rsum * (i+1)) {
                found = true;
            }
        }

        return found;
    }
}