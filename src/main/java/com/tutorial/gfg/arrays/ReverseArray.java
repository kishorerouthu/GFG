package com.tutorial.gfg.arrays;

/**
 * Created by Kishore Routhu on 15/6/17 6:27 PM.
 *
 * Write a program to reverse an array or string without using another array
 *
 * 1) Initialize start and end indexes.
 *    start = 0, end = n-1
 * 2) In a loop, swap arr[start] with arr[end] and change start and end as follows.
 *    start = start +1; end = end – 1
 */
public class ReverseArray {

    public static void main(String[] args) {
        int a[] = new int[]{4, 5, 1, 2};
        int n = a.length;
        reverse(a, n);
        printArray(a, n);
    }

    private static void reverse(int a[], int n) {
        int start = 0;
        int end = n-1;
        while (start < end) {
            //swap start end end to reverse
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;

            start++;
            end--;
        }
    }

    private static void printArray(int a[], int n) {
        for (int k : a)
            System.out.printf("%d ", k);
    }
}
