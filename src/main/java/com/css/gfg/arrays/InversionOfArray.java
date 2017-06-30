package com.css.gfg.arrays;

/**
 * @author Kishore Routhu on 28/6/17 1:06 PM.
 *
 * Problem Statement :
 * Count Inversions in an array
 *
 * Description
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted.
 * If array is already sorted then inversion count is 0.
 * If array is sorted in reverse order that inversion count is the maximum.
 * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
 *
 * Example:
 * The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 */
public class InversionOfArray {

    public static void main(String[] args) {
        int a[] = new int[]{2, 4, 1, 3, 5};
        int n = a.length;
        //int inversion = findInversion(a, n);
        int inversion = findInversionMergesort(a, n);
        System.out.printf("Inversion : " + inversion);
    }

    /*
        Method 1:
            1) For each element in the array find the number of smaller elements right to that element.
            2) Take the sum of all from step1
            Time Complexity : O(n^2)
     */
    private static int findInversion(int a[], int n) {
        int count = 0;
        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++)
                if (a[j] < a[i])
                    count ++;

        return count;
    }

    /*
        Method 2: Using MergeSort

     */
    private static int count = 0;
    private static int findInversionMergesort(int a[], int n) {
        mereSort(a, 0, n-1);
        return count;
    }

    private static void mereSort(int a[], int l, int r) {
        if (l < r) {
            int m = (l + r) >> 1;
            mereSort(a, l, m);
            mereSort(a, m+1, r);
            merge(a, l, m, r);;
        }
    }

    private static void merge(int a[], int l, int m, int r) {

        int n1 = m-l+1;
        int n2 = r-m;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = a[l+i];


        for (int j = 0; j < n2; j++)
            right[j] = a[m + 1 + j];

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
               // a[k] = left[i];
                i++;
            } else {
               // a[k] = right[j];
                j++;
                count++;
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
