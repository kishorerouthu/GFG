package com.css.gfg.stack;

import java.util.Stack;

/**
 * Next Greater Element
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the right side of x in array.
 * Elements for which no greater element exist, consider next greater element as -1.
 *
 * Examples:
 *
 * For any array, rightmost element always has next greater element as -1.
 * For an array which is sorted in decreasing order, all elements have next greater element as -1.
 * For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
 * Element       NGE
 *    4      -->   5
 *    5      -->   25
 *    2      -->   25
 *    25     -->   -1
 * d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.
 *
 *   Element        NGE
 *    13      -->    -1
 *    7       -->     12
 *    6       -->     12
 *    12      -->     -1
 */
public class NextGreater {

    public static void main(String[] args) {
        int a[] = new int[]{4, 5, 2, 25};
        nextGreaterElement(a);
    }

    private static void nextGreaterElement(int a[]) {
        int n = a.length;
        Stack<Integer> stack = new Stack();
        Stack<Integer> result = new Stack();
        for (int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.pop();
            }
            int nge = -1;
            if (!stack.isEmpty()) {
                nge = stack.peek();
            }
            stack.push(a[i]);
            result.push(nge);
        }

        while (!result.isEmpty()) {
            System.out.print(result.pop() + " ");
        }
    }
}
