package com.css.gfg.arrays;

import java.util.Arrays;

/**
 * Created by kishore on 20/2/17.
 *
 * Find Maximum dot product of two arrays with insertion of 0’s
 * Given two arrays of positive integers of size m and n where m > n.
 * We need to maximize the dot product by inserting zeros in the second array but we cannot disturb the order of elements.
 *
 * Examples:
 *
 * Input : A[] = {2, 3 , 1, 7, 8}
 *         B[] = {3, 6, 7}
 * Output : 107
 * Explanation : We get maximum dot product after
 * inserting 0 at first and third positions in
 * second array.
 * Maximum Dot Product : = A[i] * B[j]
 * 2*0 + 3*3 + 1*0 + 7*6 + 8*7 = 107
 *
 * Input : A[] = {1, 2, 3, 6, 1, 4}
 *         B[] = {4, 5, 1}
 * Output : 46
 *
 */
public class MaximumDotProduct {

    public static void main(String[] args) {

        //Test Case1
        int a[] = new int[]{2, 3 , 1, 7, 8};
        int b[] = new int[]{3, 6, 7};

        int m = a.length;
        int n = b.length;

        System.out.println(product(a, b, m, n));

        //Test Case2
        int c[] = new int[]{1, 2, 3, 6, 1, 4};
        int d[] = new int[]{4, 5, 1};

        int o = c.length;
        int p = d.length;

        System.out.println(product(c, d, o, p));

        //Test Case3 -ve numbers
        int e[] = new int[]{-3, -2, 1, 6, -5, -7};
        int f[] = new int[]{-1, 2};

        int q = e.length;
        int r = f.length;
        System.out.println(product(e, f, q, r));


    }

    private static int product(int a[], int b[], int m, int n) {
        int[] copy = Arrays.copyOfRange(a, 0, m);

        sort(a, 0, m-1);

        int limit = a[(m - n) -1];
        int product = 0;
        int j = 0, i=0;

        while(i < m && j < n) {
            product += ((copy[i] <= limit) ? 0 : b[j++]) * copy[i++];
        }
        return product;
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
