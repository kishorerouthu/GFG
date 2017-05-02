package com.tutorial.gfg.arrays;

/**
 * Created by kishore on 16/3/17.
 */

/*
         Problem Statement : Write an efficient program for printing k largest elements in an array.
                            Elements in array can be any order.

          Example : Given an array is [1, 23, 12, 9, 30, 2, 50] and you asked for the largest 3 elements i.e k=3
                    then your program should print 50, 30, 23.

          Method1 : Use Bubble short k times
                    1) Modify Bubble Sort to run the outer loop at most k times
                    2) Print the last k elements of the array obtained in step1.

                    Time Complexity: O(nk)

                    Like Bubble Sort other sorting algorithms like Selection Sort can also be modified to get k largest elements.

 */
public class KLargestElements {

    public static void main(String[] args) {
        int a[] = new int[] {1, 23, 12, 9, 30, 2, 50};  //50 23 30
        //kLargest2(a, 3);
        kLargest4(a, a.length, 3);
        for (int v : a)
            System.out.println(v);
    }

    /*
        Method2 : Use temporary array
                1) Take a temporary array of size k
                2) Store the first k elements in the temporary array temp[0...k-1]
                3) Find the smallest element the temp[] array, let the smallest element be min
                4) For each element x in arr[k] to arr[n-1]
                5) If x is greater than the min then replace min with x in temp[] array
                6) Print final k elements of temp[]

                Time complexity: O((n-k)*k). If we want the output sorted then O((n-k)*k + klogk)
     */

    public static void kLargest2(int a[], int k) {

        int n = a.length;
        if (k < 0 || k > n)
            return;

        int temp[] = new int[k];
        for (int i = 0; i < k; i++)
            temp[i] = a[i];

        for (int j = k; j < n; j++) {
            int min_index = 0;
            int min_value = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                if (temp[i] < min_value) {
                    min_value = temp[i];
                    min_index = i;
                }
            }

            if (a[j] > min_value)
                temp[min_index] = a[j];
        }

        for (int v : temp)
            System.out.print(v +" ");
    }


    /*
        Method3 : Use Sorting
                1) Sort the elements in descending order in O(nlong)
                2) Print the first k number of sorted array O(k)

                Time Complexity : O(nlogn)
     */

     /*
        Method4 : Use max Heap
                1) Build a max Heap tree in O(n)
                2) Use Extract Max k times to get k maximum elements from the Max Heap O(klogn)

                Time Complexity : O(n + klogn)
      */

       private static void kLargest4(int a[], int n, int k) {

           maxHeap(a, n);

            for (int i = n-1, j=0; i >= 0 && j<k; i--,j++) {
                //swap i with 0 top max element
                int max = a[0];
                a[0] = a[i];
                a[i] = max;
                heapify(a, i, 0);
            }
       }

       private static void heapify(int a[], int n, int i) {

           int left = (i << 1) + 1;
           int right = (i + 1) << 1;
           int largest = i;

           if (left < n && a[left] > a[largest])
               largest = left;

           if (right < n && a[right] > a[largest])
               largest = right;

           if (largest != i) {
               //swap largest with i
               int temp = a[i];
               a[i] = a[largest];
               a[largest] = temp;

               heapify(a, n, largest);
           }
       }

       private static void maxHeap(int a[], int n) {
           for (int i = n/2 -1; i>=0; i--) {
                heapify(a, n, i);
           }
       }
}