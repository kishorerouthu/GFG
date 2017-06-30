package com.css.gfg.arrays;

/**
 * Created by kishore on 29/1/17.
 *
 * Find all elements in array which have at-least two greater elements
 * Given an array of n distinct elements, the task is to find all elements in array
 * which have at-least two greater elements than themselves.
 *
 * Examples:
 *
 * Input : arr[] = {2, 8, 7, 1, 5};
 * Output : 2  1  5
 * The output three elements have two or more greater elements
 *
 * Input  : arr[] = {7, -2, 3, 4, 9, -1};
 * Output : -2  3  4 -1
 *
 */
public class HaveTwoGreaterElements {

    public static void main(String[] args) {
        int a[] = new int[] {2, 8, 7, 1, 5};
        findElements(a, a.length);
        int a1[] = new int[] {7, -2, 3, 4, 9, -1};
        findElements(a1, a1.length);
    }

    private static void findElements(int a[], int n) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (a[i] > first) {
                second = first;
                first = a[i];
            } else if(a[i] > second) {
                second = a[i];
            }
        }

        for (int i = 0; i < n; i++)
            if (a[i] < second)
                System.out.println(a[i]);

    }
}
