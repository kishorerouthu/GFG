package com.css.gfg.arrays;

/**
 * Created by Kishore Routhu on 14/6/17 8:35 PM.
 *
 * Search an element in a sorted and rotated array
 * An element in a sorted array can be found in O(log n) time via binary search.
 * But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.
 *
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 * key = 3
 * Output : Found at index 8
 *
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 * key = 30
 * Output : Not found
 *
 * Input : arr[] = {30, 40, 50, 10, 20}
 * key = 10
 * Output : Found at index 3
 */

public class RotateArraySearch {

    public static void main(String[] args) {
        int arr[] = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
        int n = arr.length;
        int result = pivotBinarySearch(arr, n, 3);
        System.out.println(result);
    }

    private static int pivotBinarySearch(int a[], int n, int k) {
        int p = findPivot(a, 0, n-1);

        //If we didn't find a pivot, then array is not rotated at all
        if (p == -1)
            return bSearch(a, 0, n-1, k);

        //If we found a pivot, then first compare with pivot and then
        //search in two subarrays around pivot
        if (a[p] == k)
            return p;

        if (a[0] <= k)
            return bSearch(a, 0, p-1, k);
        return bSearch(a, p+1, n-1, k);
    }


    private static int bSearch(int a[], int l, int h, int k) {

        //base case
        if (h < l) return -1;

        int m = (l + h) >> 1;
        if (a[m] == k)
            return m;
        if (a[m] < k)
            return bSearch(a, m+1, h, k);
        return bSearch(a, l, m-1, k);
    }

    private static int findPivot(int arr[], int low, int high) {

        //base cases
        if (high < low) return -1;
        if (high == low) return low;

        int mid = (low + high) >> 1;

        if (high > mid && arr[mid] > arr[mid + 1])
            return mid;

        if (mid > low && arr[mid] < arr[mid-1])
            return mid - 1;

        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);

        return findPivot(arr, mid + 1, high);

    }

}

