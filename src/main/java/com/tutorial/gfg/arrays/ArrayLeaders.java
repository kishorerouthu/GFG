package com.tutorial.gfg.arrays;

/**
 * Write a program to print all the LEADERS in the array.
 * An element is leader if it is greater than all the elements to its right side.
 * And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 *
 * @author Kishore Routhu on 21/6/17 8:15 PM.
 */

public class ArrayLeaders {

    public static void main(String[] args) {
        int a[] = new int[]{16, 17, 4, 3, 5, 2};
        int n = a.length;
        findLeaders2(a, n);
    }

    /*
        Method 1 : Naive approach
                 1. Run Loop : For each element in the array
                 2. Compare with elements right the current element
                 3. If found any element such that a[j] > a[i] then not Leader

            Worst Case Complexity : O(n^2)
     */
    private static void findLeaders(int a[], int n) {

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n) {
                if (a[j] > a[i]) break;
                j++;
            }

            if (j == n)
                System.out.printf("%d ", a[i]);
        }
    }

    /*
        Method 2 :
                1. Take an index which contains previous leader position (pli).
                2. Initialize pli to a[n-1], as last element always leader
                3. Run loop i from n-2 to 0 and for each element
                4. If a[i] > a[pli] then print a[i] as leader and pli = i
     */
    private static void findLeaders2(int a[], int n) {
        int pli = n-1;
        int i = n-2;
        System.out.printf("%d ", a[pli]);
        while (i >= 0) {
            if (a[i] > a[pli]) {
                pli = i;
                System.out.printf("%d ", a[pli]);
            }
            i--;
        }
    }
}
