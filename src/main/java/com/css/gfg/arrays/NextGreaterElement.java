package com.css.gfg.arrays;

/**
 * Next Greater Element
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the right side of x in array.
 * Elements for which no greater element exist, consider next greater element as -1.
 *
 * Examples:
 * a) For any array, rightmost element always has next greater element as -1.
 * b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
 * c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
 *
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
 *    12     -->     -1
 *
 *
 * @author Kishore Routhu on 22/6/17 6:01 PM.
 */
public class NextGreaterElement {

    private static final int DEFAULT_STACK_SIZE = 50;

    public static void main(String[] args) {
        int a[] = new int[]{4, 5, 2, 25};
        int n = a.length;
        findNextGreaterStack(a, n);
    }


    /*
        Method 1 : Naive Approach
                   1. Run 2 loops
                   2. For each element from the first loop find the
                      2a. Run 2nd loop from next element of current element
                      2b. If any element found such that a[j] > a[i] then print a[j] as next greater element
                      2c. Else print -1

        Time Complexity : O(n^2)
     */
    private static void findNexGreater(int a[], int n) {
        for (int i = 0; i < n; i++) {
            int j;
            for (j= i + 1; j < n; j++)
                if (a[j] > a[i]) {
                    System.out.println(a[i] + " --- " + a[j]);
                    break;
                }

            if (j == n) System.out.println(a[i] + " --- -1");
        }
    }

    /*
        Method 2: Using Stack
                1. Push the first element to stack
                2. Run loop from 2nd element to end of the array

                3. For each element
                    3a. Take TOP element from stack, let current element be NEXT
                    3b. If NEXT > TOP then print NEXT as next greater for TOP element and pop out the TOP element
                    3c. Repeat step 3a..3b until meet the condition NEXT < TOP or Stack becomes empty.
                    3d. Push NEXT to stack, to find next greater of NEXT

                4. Print -1 for all the remaining elements in the stack

                Time Complexity : O(n)
     */
    private static void findNextGreaterStack(int a[], int n) {
        Stack stack = new Stack(DEFAULT_STACK_SIZE);

        //1. Push first element to stack
        stack.push(a[0]);

        for (int i = 1; i < n; i++) {
            int next = a[i];

            //3
            if (!stack.isEmpty()) {
                int top = stack.top();
                //3c
                while (next > top) {
                    printPair(top, next);
                    stack.pop();

                    if (stack.isEmpty())
                        break;

                    top = stack.top();
                }
            }

            //3d. Push NEXT as we need to find next greater of it
            stack.push(next);
        }

        while (!stack.isEmpty()) {
            printPair(stack.pop(), -1);
        }
    }

    private static void printPair(int a, int b) {
        System.out.println(a + " --- " + b);
    }

    private static class Stack {

        int stack[] = null;
        int top = -1;

        public Stack(int size) {
            stack = new int[size];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void push(int data) {
            if (top == stack.length) {
                throw new IllegalStateException("Stack Overflow...!");
            }
            stack[++top] = data;
        }

        public int pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack Underflow...!");
            }
            return stack[top--];
        }

        public int top() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack Underflow...!");
            }
            return stack[top];
        }
    }

}
