package com.css.gfg.arrays;

/**
 * Created by Kishore Routhu on 15/6/17 6:37 PM.
 *
 * Program for array rotation
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 *
 * Example : 1 2 3 4 5 6 7
 *          Rotate by 2 will make array
 *          3 4 5 6 7 1 2
 */
public class RotateArray {

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = a.length;
        rotate2(a, n, 2);
        printArray(a, n);
    }

    /*
        Method 1: Naive approach
                 1. Take the element from rotate index
                 2. Shift all the elements after the rotate index to one step
                 3. Place the element from first step to last

         Time Complexity : n*d
     */
    private static void rotate(int a[], int n, int d) {

        //rotate index
        int l_index = d-1;

        //right index to place rotated elements
        int r_index = n-1;

        while (l_index >= 0) {
            int tmp = a[l_index];
            shift(a, l_index, r_index);
            a[r_index] = tmp;
            l_index--;
        }
    }

    private static void shift(int a[], int from, int to) {
        while (from < to) {
            a[from] = a[from+1];
            from++;
        }
    }

    /*
        Method2 : Using temp arrays
                1. Move all d elements to temp array
                2. Shift the remaining to left
                3. Place temp array to right side

        Time Complexity : O(n)
    */
    private static void rotate2(int a[], int n, int d) {
        int tmp[] = new int[d];
        int i = d-1;

        while (i >= 0)
            tmp[i] = a[i--];

        //shift the remaining n-d elements
        int r = d;
        int l = 0;
        while (r < n) {
            a[l] = a[r];
            r++;
            l++;
        }

        for (int e : tmp) {
            a[l] = e;
            l++;
        }
    }

    private static void printArray(int a[], int n) {
        for (int k : a)
            System.out.printf("%d ", k);
    }
}
