package com.tutorial.gfg.arrays;

/**
 * Created by kishore on 20/2/17.
 *
 * Chose k array elements such that difference of maximum and minimum is minimized
 * Given an array of n integers and a positive number k.
 * We are allowed to take any k integers from the given array.
 * The task is to find the minimum possible value of the difference between maximum and minimum of K numbers.
 *
 * Examples:
 *
 * Input : arr[] = {10, 100, 300, 200, 1000, 20, 30}
 *         k = 3
 *
 * Output : 20
 * 20 is the minimum possible difference between any
 * maximum and minimum of any k numbers.
 * Given k = 3, we get the result 20 by selecting
 * integers {10, 20, 30}.
 * max(10, 20, 30) - max(10, 20, 30) = 30 - 10 = 20.
 *
 * Input : arr[] = {1, 2, 3, 4, 10, 20, 30, 40,
 *                                    100, 200}.
 *         k = 4
 * Output : 3
 *
 */
public class ChooseKArrayElements {

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 10, 20, 30, 40,100, 200};
        int k = 4;
        int n = arr.length;
        int result = minimum(arr, n, k);
        System.out.println(result);
    }

    private static int minimum(int a[], int n, int k) {

        sort(a, 0, n-1);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n-k; i++)
            result = Math.min(result, (a[i+k-1] - a[i]));

        return result;
    }

    private static void sort(int a[], int l, int r) {
        if (l < r) {
            int m = (r + l) >> 1;
            sort(a, l, m);
            sort(a, m+1, r);
            merge(a, l, m, r);
        }
    }

    private static void merge(int a[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int left[] = new int[n1];
        int right[] = new int[n2];


        for (int i=0; i<n1; i++)
            left[i] = a[l+i];

        for (int j=0; j<n2; j++)
            right[j] = a[m + 1 + j];


        int i = 0;
        int j = 0;
        int k = l;

        while(i < n1 && j < n2) {

            if (left[i] <= right[j]) {
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = right[j];
            j++;
            k++;
        }
    }
}


