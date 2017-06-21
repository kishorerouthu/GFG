package com.tutorial.gfg.arrays;

import java.util.*;

/**
 * Created by Kishore Routhu on 20/6/17 8:43 PM.
 *
 * Find a pair with the given difference
 * Given an unsorted array and a number n, find if there exists a pair of elements in the array whose difference is n.
 *
 * Examples:
 * Input: arr[] = {5, 20, 3, 2, 50, 80}, n = 78
 * Output: Pair Found: (2, 80)
 *
 * Input: arr[] = {90, 70, 20, 80, 50}, n = 45
 * Output: No Such Pair
 *
 */

public class DifferencePair {

    public static void main(String[] args) {
        int a[] = new int[]{5, 20, 3, 2, 50, 80};
        int d = 78;
        //int a[] = new int[]{90, 70, 20, 80, 50};
        //int d = 45;
        int n = a.length;
        boolean pairExists = findPair(a, n, d);
        System.out.println(pairExists);
    }

    /*
    This method works by Hashing
    1. Run Loop through array till the end and for each element
    2. Calculate the differenc of a[i] and d as follows
      2.a. If a[i] > d then diff = a[i] - d
      2.b. If a[i] < d then diff = a[i] + d
    3. If HashTable contains the the diff then the pair will be (diff, a[i])
    4. Else add a[i] to HashTable
*/
    private static boolean findPair(int a[], int n, int d) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            int diff = a[i] > d? (a[i] -d) : (a[i] + d);
            if (list.contains(diff))
                return true;
            else
                list.add(a[i]);
        }

        return false;
    }
    /*
        Method 2 : This approach takes the following steps
                    1. Sorts the arrays in ascending order
                    2. Take 2 index variables i and j, and initialize i to 0 and j to 1.
                    3. Now run the loop. If arr[j] - arr[i] < d, we need to look for greater arr[j], so increment j.
                    4. If arr[j] - arr[i] > d, we need to look for greater arr[i], so increment i.
     */
    public static boolean findPairSort(int a[], int n, int d) {

        Arrays.sort(a);

        int i = 0;
        int j = 1;
        while (i < n && j < n) {
            if (i != j && a[j] - a[i] == d)
                return true;
            if (a[j] - a[i] < d)
                j++;
            else if (a[j] - a[i] > d)
                i++;
        }

        return false;
    }
}
