package com.css.gfg.strings;

/**
 * @author Kishore Routhu on 20/1/18 2:17 PM.
 * Write program for printing combinations of a string ? Combinations of 3 sets like
 * [1, 2, 3] [A, B, C] [#, $, %]
 * Combinations :
 * [1, A, #]	[2,A,#]		[3,A,#]
 * [1, A, $]	[2,A,$]		[3,A,$]
 * [1, A, %]	[2,A,%]	    [3,A,%]
 * [1, B, #]	[2,B,#]		[3,B,#]
 * [1, B, $]	[2,B,$]		[3,B,$]
 * [1, B, %]	[2,B,%]	    [3,B,%]
 * [1,C,#]		[2,C,#]	    [3,C,#]
 * [1,C,$]		[2,C,$]		[3,C,$]
 * [1,C,%]	   [2,C,%]	   [3,C,%]
 */
public class CombinationsOfSets {

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3};
        char b[] = new char[]{'A', 'B', 'C'};
        char c[] = new char[]{'#', '$', '%'};
        combinations(a, b, c);
    }

    /**
     * Naive approach run 3 loops one for each set and print combinations
     *
     * Time Complexity O(n^3)
     */
    private static void combinations(int a[], char b[], char c[]) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b.length; j++)
                for (int k = 0; k < c.length; k++)
                    System.out.println(++count + ":" + a[i] + "" +b[j] + "" + c[k]);
    }
}
