package com.css.gfg.dp;

/**
 * Created by kishore on 3/5/17.
 *
 * Dynamic Programming | Set 13 (Cutting a Rod)
 *
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 *
 * The naive solution for this problem is to generate all configurations of different pieces and find the highest priced configuration.
 * This solution is exponential in term of time complexity.
 * Let us see how this problem possesses both important properties of a Dynamic Programming (DP)
 * Problem and can efficiently solved using Dynamic Programming.
 *
 * 1) Optimal Substructure:
 * We can get the best price by making a cut at different positions and comparing the values obtained after a cut.
 * We can recursively call the same function for a piece obtained after a cut.
 *
 * Let cutRoad(n) be the required (best possible price) value for a rod of lenght n. cutRod(n) can be written as following.
 *
 * cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}
 *
 * 2) Overlapping Subproblems
 * Following is simple recursive implementation of the Rod Cutting problem.
 * The implementation simply follows the recursive structure mentioned above.
 *
 */
public class Set13CutARod {


    public static void main(String[] args) {
        int prices[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int n = prices.length;
        System.out.println(cutRodDP(prices, n));
    }

    /*
        Naive recursive which has exponential TimeComplexity
     */
    private static int cutRod(int prices[], int n) {
        if (n<=0)
            return 0;

        int max_val = Integer.MIN_VALUE;

        //Recursively cut the rod at different positions and compare different configurations
        for (int i = 0; i < n; i++)
            max_val = Math.max(max_val, prices[i] + cutRod(prices, n-i-1));
        return max_val;
    }

    /*
     Dynamic Programming
     Re-computations of same subproblems can be avoided by constructing a temporary array val[] in bottom up manner.
     Time Complexity : O(n^2) which is much better than the worst case time complexity of Naive Recursive implementation.
     */
    private static int cutRodDP(int prices[], int n) {
        int val[] = new int[n+1];
        val[0] = 0;

        int max_value = Integer.MIN_VALUE;
        for (int i = 1; i <=n ; i++) {
                for (int j = 0; j < i; j++)
                    max_value = Math.max(max_value, prices[j] + val[i-j-1]);

                val[i] = max_value;
        }

        return val[n];
    }
}
