package com.css.gfg.arrays;

/**
 * Created by Kishore Routhu on 10/6/17 8:43 PM.
 */
public class CurdSortedArray {

    public static void main(String[] args) {

        int capacity = 6;
        int arr[] = new int[capacity];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 40;
        arr[3] = 50;
        arr[4] = 70;
        int n = 5;
        System.out.println(binarySearch(arr, 0, n-1, 40));
        n = insert(arr, n, capacity, 30);
        System.out.println("After Insert : ");
        print(arr, n);
        n = delete(arr, n, 50);
        System.out.println();
        System.out.println("After Delete : ");
        print(arr, n);
    }

    private static void print(int a[], int n) {
        for (int i = 0; i < n; i++)
            System.out.printf("%2d ", a[i]);
    }
    //Search Operation
    //In a sorted array, the search operation can be performed using binary search
    private static int binarySearch(int a[], int low, int high, int key) {

        if (high < low)
            return -1;

        int mid = (low + high) >> 1;
        if (a[mid] == key)
            return mid;

        if (a[mid] < key)
           return binarySearch(a, mid+1, high, key);
        return binarySearch(a, low, mid-1, key);
    }

    //Insert Operation
    //In an unsorted array, the insert operation is faster as compared to sorted array because we don't
    //have to care about the position at which element to be placed
    private static int insert(int a[], int n, int capacity, int key) {

        //cannot insert more elements if n is already more than or equal to capacity
        if (n >= capacity)
            return n;

        int i = 0;
        for (i=n-1; i>0 && a[i]>key; i--)
            a[i+1] = a[i];

        a[i+1] = key;

        return n+1;
    }

    //Delete Operation
    //In delete operation, the element to be deleted is searched using binary search and then delete
    //operation is performed followed by shifting the elements
    private static int delete(int a[], int n, int key) {
        int pos = binarySearch(a, 0, n-1, key);
        if (pos == -1) {
            System.out.println("Element not found");
            return n;
        }

        for (int i = pos; i < n-1; i++) {
            a[i] = a[i+1];
        }

        return n-1;
    }
}
