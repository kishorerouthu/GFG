package com.css.gfg.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Next Greater Frequency Element
 * Given an array, for each element find the value of nearest element to the right which is having frequency greater than as that of current element. If there does not exist an answer for a position, then make the value ‘-1’.
 *
 * Examples:
 *
 * Input : a[] = [1, 1, 2, 3, 4, 2, 1]
 * Output : [-1, -1, 1, 2, 2, 1, -1]
 * Explanation:
 * Given array a[] = [1, 1, 2, 3, 4, 2, 1]
 * Frequency of each element is: 3, 3, 2, 1, 1, 2, 3
 * Lets calls Next Greater Frequency element as NGF
 * 1. For element a[0] = 1 which has a frequency = 3,
 *    As it has frequency of 3 and no other next element
 *    has frequency more than 3 so  '-1'
 * 2. For element a[1] = 1 it will be -1 same logic
 *    like a[0]
 * 3. For element a[2] = 2 which has frequency = 2,
 *    NGF element is 1 at position = 6  with frequency
 *    of 3 > 2
 * 4. For element a[3] = 3 which has frequency = 1,
 *    NGF element is 2 at position = 5 with frequency
 *    of 2 > 1
 * 5. For element a[4] = 4 which has frequency = 1,
 *    NGF element is 2 at position = 5 with frequency
 *    of 2 > 1
 * 6. For element a[5] = 2 which has frequency = 2,
 *    NGF element is 1 at position = 6 with frequency
 *    of 3 > 2
 * 7. For element a[6] = 1 there is no element to its
 *    right, hence -1
 *
 * Input : a[] = [1, 1, 1, 2, 2, 2, 2, 11, 3, 3]
 * Output : [2, 2, 2, -1, -1, -1, -1, 3, -1, -1]
 */
public class NGFE {
    public static void main(String[] args) {
        int a[] = new int[]{1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
        ngfe(a);
    }

    private static void ngfe(int a[]) {;
        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        final Stack<Stock> stack = new Stack<Stock>();
        final Stack<Integer> rStack = new Stack<Integer>();
        int n = a.length;
        for (int i=0; i<n; i++) {
            Integer count = (map.get(a[i]) == null)? 0 : map.get(a[i]);
            map.put(a[i], ++count);
        }

        for (int i=n-1; i>=0; i--) {
            Stock stock = new Stock(i, a[i], map.get(a[i]));
            while (!stack.isEmpty() && stack.peek().count <= stock.count) {
                stack.pop();
            }
            int result = stack.isEmpty()? -1 : stack.peek().value;
            rStack.push(result);
            stack.push(stock);
        }

        while (!rStack.isEmpty()) {
            System.out.print(rStack.pop() + " ");
        }
    }

    private static class Stock {
        int index;
        int value;
        int count;

        public Stock(int index, int value, int count) {
            this.index = index;
            this.value = value;
            this.count = count;
        }
    }

}

