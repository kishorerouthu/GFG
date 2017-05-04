package com.tutorial.gfg.dp;

/**
 * Created by kishore on 4/5/17.
 *
 * Problem Statement :
 *
 * Given a value N, if we want to make change for N cents,
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
 * The order of coins doesn’t matter.
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4. For N = 10 and S = {2, 5, 3, 6},
 * there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 *
 *
 * 1. Optimal substructure
 * To count total number solutions, we can divide all set solutions in two sets.
 *      1. Solutions that do not contain mth coin
 *      2. Solutions that contain at least one mth coin
 *      m - size
 *      n - sum
 *     Let count(s[], m, n) be a function to count the number of solutions, then it can be written as sum
 *     of count(s[], m-1,n) and count(s[],m,n-s[m-1])
 */
public class Set7CoinChange {

    public static void main(String[] args) {
        int s[] = new int[] {2, 5, 3, 6};
        int n = 10;
        int m = s.length;
        int solutions = countDP(s, m, n);
        System.out.println(solutions);
    }

    private static int count(int s[], int m, int n) {

        //Boundary conditions

        //If sum is 0 then there is 1 solution (do not include any coin)
        if (n == 0)
            return 1;

        //If n less than 0 then no solution exists
        if (n < 0)
            return 0;

        //If there are no coins and sum greater than 0 there is no solution
        if (m <= 0 && n >= 1)
            return 0;

        //count is sum of solutions (i) excluding s[m-1] (ii) including s[m-1]
        return count(s, m-1, n) + count(s, m, n-s[m-1]);

    }

    private static int countDP(int s[], int m, int n) {
                        //[sum][coins]
        int t[][] = new int[n+1][m];

        //for sum 0 there is only on solution, no need of coins
        for (int i=0; i<m; i++)
            t[0][i] = 1;

        int x, y;
        //Fill the remaining cells
        for (int i=1; i<=n; i++) {
            for (int j=0; j<m; j++) {

                //find solutions including s[j]
                x = (i-s[j]) >= 0 ? t[i-s[j]][j] : 0;

                //find solutions excluding s[j]
                y = (j >= 1)? t[i][j-1] : 0;

                t[i][j] = x + y;
            }
        }

        return t[n][m-1];
    }

}
