package com.css.gfg.arrays;

/**
 * @author Kishore Routhu on 28/6/17 11:22 AM.
 *
 * Problem Statement : Median of two sorted arrays
 *   Question: There are 2 sorted arrays A and B of size n each.
 *   Write an algorithm to find the median1 of the array obtained after merging the above 2 arrays(i.e. array of length 2n).
 *  The complexity should be O(log(n))
 *
 * Description :
 * Median: In probability theory and statistics,
 * a median1 is described as the number separating the higher half of a sample, a population,
 * or a probability distribution, from the lower half.
 *
 * The median1 of a finite list of numbers can be found by arranging all the numbers from
 * lowest value to highest value and picking the middle one.
 *
 * For getting the median1 of input array { 12, 11, 15, 10, 20 }, first sort the array.
 * We get { 10, 11, 12, 15, 20 } after sorting. Median is the middle element of the sorted array which is 12.
 *
 * There are different conventions to take median1 of an array with even number of elements,
 * one can take the mean of the two middle values, or first middle value, or second middle value.
 *
 * Let us see different methods to get the median1 of two sorted arrays of size n each.
 * Since size of the set for which we are looking for median1 is even (2n),
 * we take average of middle two numbers in all below solutions and return floor of the average.
 */

public class MedianOf2SortedArrays {

    public static void main(String[] args) {

        int a[] = {1, 12, 15, 26, 38};
        int b[] = {2, 13, 17, 30, 45};
        int n = a.length;

        //int median = median1(a, b, n);
        int median = median2(a, b,0, 0, n);
        System.out.printf("Median :: " + median);
    }

    /*
        Method 1 (Counting while Merging)
        Use merge procedure of merge sort. Keep track of count while comparing elements of two arrays.
        If count becomes n(For 2n elements), we have reached the median1.
        Take the average of the elements at indexes n-1 and n in the merged array.
        See the below implementation.
     */
    private static int median1(int a[], int b[], int n) {
        int m1 = -1; //Median 1
        int m2 = -1; //Median 2

        int i = 0; //index of array a
        int j = 0; //index of array b

        for (int count = 0; count <= n; count++) {

            /* Below is to handle case where all elements of a[] are
               smaller than smallest(or first) element of b[] */
            if (i == n) {
                m1 = m2;
                m2 = b[0];
                break;
            }


        /*
          Below is to handle case where all elements of b[] are
          smaller than smallest(or first) element of a[]
          */
            if (j == n) {
                m1 = m2;
                m2 = a[0];
                break;
            }

            if (a[i] <= b[j]) {
                m1 = m2;
                m2 = a[i];
                i++;
            } else {
                m1 = m2;
                m2 = b[j];
                j++;
            }
        }
        return (m1 + m2)/2; //For even number of elements median1 will be average of 2 middle elements
    }

    /*
        Method 2 (By comparing the medians of two arrays)
        This method works by first getting medians of the two sorted arrays and then comparing them.

    Let a and b be the input arrays.

    Algorithm:

    1) Calculate the medians m1 and m2 of the input arrays b[]
    and b[] respectively.

    2) If m1 and m2 both are equal then we are done.
     return m1 (or m2)

    3) If m1 is greater than m2, then median is present in one
    of the below two sub-arrays.
        a)  from first element of a1 to m1
        b)  from m2 to last element of b

    4) If m2 is greater than m1, then median is present in one
    of the below two subarrays.
        a)  from m1 to last element of a
        b)  from first element of b to m2

    5) Repeat the above process until size of both the subarrays
    becomes 2.

    6) If size of the two arrays is 2 then use below formula to get
    the median.
        Median = (max(a[0], b[0]) + min(a[1], b[1]))/2

        Time Complexity : O(log n)
    */
    private static int median2(int a[], int b[], int as, int bs, int n) {

        if (n <= 0)
            return -1;

        if (n == 1)
            return (a[0] + b[0]) / 2;

        if (n == 2)
            return (Math.max(a[as], b[bs]) + Math.min(a[as+1], b[bs+1])) / 2;

        int m1 = median(a, as, n);
        int m2 = median(b, bs, n);

        //2. If both medians m1 and m2 are equal then return m1 / m2;
        if (m1 == m2) return m1;

        if (m1 < m2) {
            if (n % 2 == 0)
                return median2(a, b, n / 2 - 1, bs, n - n / 2 + 1);
            return median2(a, b, n / 2, bs, n - n / 2);
        }

        if (n % 2 == 0)
            return median2(a, b, as, n/2-1, n-n/2 + 1);
        return median2(a, b, as, n/2, n-n/2);
    }

    private static int median(int a[], int start, int n) {
        if (n % 2 == 0)
            return (a[start + n/2] + a[start + n/2-1]) / 2;
        return a[start + n/2];
    }


}
