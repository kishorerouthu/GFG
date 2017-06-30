package com.css.gfg.arrays;

/**
 * Created by kishore on 20/2/17.
 *
 * Problem Statement :
 * Given two arrays of equal size n and an integer k.
 * The task is to permute both arrays such that sum of their corresponding element is greater than or equal to k i.e a[i] + b[i] >= k.
 * The task is print “Yes” if any such permutation exists, otherwise print “No”.
 *
 * Examples:
 * Input : a[] = {2, 1, 3},
 *         b[] = { 7, 8, 9 },
 *         k = 10.
 * Output : Yes
 *
 * Permutation  a[] = { 1, 2, 3 } and b[] = { 9, 8, 7 }
 * satisfied the condition a[i] + b[i] >= K.
 *
 * Input : a[] = {1, 2, 2, 1},
 *         b[] = { 3, 3, 3, 4 },
 *         k = 5.
 * Output : No
 *
 * The idea is to sort one array in ascending order and another array in descending order
 * and if any index does not satisfy the condition a[i] + b[i] >= K then print “No”, else print “Yes”.
 *
 * If the condition fails on sorted arrays, then there exists no permutation of arrays which can satisfy the inequality.
 *
 * Proof,
 *
 * Assume asort[] be sorted a[] in ascending order and bsort[] be sorted b[] in descending order.
 * Let new permutation b[] is created by swapping any two indices i, j of bsort[],
 *
 * Case 1: i < j and element at b[i] is now bsort[j].
 * Now, asort[i] + bsort[j] < K, because bsort[i] > bsort[j] as b[] is sorted in decreasing order and we know asort[i] + bsort[i] < k.
 * Case 2: i > j and element at b[i] is now bsort[j].
 * Now, asort[j] + bsort[i] < k, because asort[i] > asort[j] as a[] is sorted in increasing order and we know asort[i] + bsort[i] < k.
 */
public class Permute2Arrays {

    public static void main(String[] args) {

        //Test Case1
        int a[] = new int[]{2, 1, 3};
        int b[] = new int[]{7, 8, 9};
        int k = 10;
        String result = isPossible(a, b, 3, k) ? "Yes" : "No";
        System.out.println(result);

        //Test Case2
        int a1[] = new int[]{1, 2, 2, 1};
        int b1[] = new int[]{ 3, 3, 3, 4 };
        int k1 = 5;
        String result1 = isPossible(a1, b1, 4, k1) ? "Yes" : "No";
        System.out.println(result1);

    }


    private static boolean isPossible(int a[], int b[], int n, int k) {

        sort(a, 0, n-1, false);
        sort(b, 0, n-1, true);

        for (int i = 0; i < n; i++)
            if (a[i] + b[i] < k)
                return false;
        return true;
    }

    /**
     * Quick Sort
     * @param a - Array to be sort
     * @param l - Left bound of the array
     * @param r - Right bound of the array
     * @param desc - if true array will be sorted in descending order, otherwise ascending order
     */
    private static void sort(int a[], int l, int r, boolean desc) {

        if (l < r) {
            int p = partition(a, l, r, desc);
            sort(a, l, p-1, desc);
            sort(a, p+1, r, desc);
        }

    }

    private static int partition(int a[], int l, int r, boolean desc) {

        int i = l-1;
        int j = l;
        int p = a[r];

        while(j < r) {

            if (desc) {
                if (a[j] > p) {
                    i++;
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            } else if (a[j] < p) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            j++;
        }

        a[r] = a[i+1];
        a[i+1] = p;

        return i + 1;
    }
}
