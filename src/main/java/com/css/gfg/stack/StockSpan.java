package com.css.gfg.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * The Stock Span Problem
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 *
 * @link https://www.geeksforgeeks.org/the-stock-span-problem/
 */
public class StockSpan {

    public static void main(String[] args) {
        int a[] = new int[]{100, 80, 60, 70, 60, 75, 85};
        //int r[] =  stockSpanBruteForce(a);
        int r[] = stockSpanStock(a);
        System.out.println(Arrays.toString(r));
    }

    /**
     * Method1: Using Brute Force approach
     */
    private static int[] stockSpanBruteForce(int[] a) {
        int r[] = new int[a.length];
        for (int i=0; i<a.length; i++) {
            int count = 0;;
            for (int j=i; j>=0; j--) {
                if (a[j] <= a[i]) {
                    count++;
                } else {
                    break;
                }
            }
            r[i] = count;
        }
        return r;
    }

    /**
     * Method2: Using Stack
     */
    private static int[] stockSpanStock(int a[]) {
        final Stack<Stock> stack = new Stack<Stock>();
        int n = a.length;
        int r[] = new int[n];
        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && stack.peek().value <= a[i]) {
                stack.pop();
            }
            r[i] = stack.isEmpty()? i+1 : (i - stack.peek().index);
            stack.push(new Stock(i, a[i]));
        }
        return r;
    }

    private static class Stock {
        int index;
        int value;

        public Stock(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
