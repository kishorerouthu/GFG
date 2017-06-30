package com.css.gfg.arrays;

/**
 * Created by Kishore Routhu on 15/6/17 6:04 PM.
 *
 * Merge an array of size n into another array of size m+n
 *
 * Question:
 * There are two sorted arrays. First one is of size m+n containing only m elements.
 * Another one is of size n and contains n elements.
 * Merge these two arrays into the first array of size m+n such that the output is sorted.
 *
 */

public class MergeArrays {

    //Consider NA as -1 in arrays
    public static void main(String[] args) {
        int mna[] = new int[]{2, -1, 7, -1, -1, 10, -1};
        int na[] = new int[]{5, 8, 12, 14};

        int n = na.length;
        int m = mna.length - n;

        moveToEnd(mna, m+n);
        merge(mna, na, m, n);

        printArray(mna, m+n);
    }

    /*
        The idea is to move all the elements in m+n array to the right of the array
        And then merge them using the merge short technique
     */

    private static void moveToEnd(int mn[], int size) {
        int j = size-1;
        for (int i = size-1; i>=0; i--) {
            if (mn[i] != -1) {
                mn[j] = mn[i];
                mn[i] = -1;
                j--;
            }
        }
    }

    private static void merge(int mna[],  int na[], int m, int n) {
        //current merge index of mna arrays
        int i = n;

        //current merge index of na arrays
        int j = 0;

        //current index of mna array
        int k = 0;

        while (k < (m+n)) {
            if ((i< (m+n) && mna[i] < na[j]) || (j == n) ) {
                mna[k] = mna[i];
                i++;
                k++;
            } else {
                mna[k] = na[j];
                j++;
                k++;
            }
        }

    }

    private static void printArray(int a[], int n) {
        for (int k : a)
            System.out.printf("%d ", k);
    }
}
