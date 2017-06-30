package com.css.gfg.dp;

/**
 * Created by kishore on 3/5/17.
 Dynamic Programming | Set 11 (Egg Dropping Puzzle)
 The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.

 Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from,

 and which will cause the eggs to break on landing. We make a few assumptions:

 …..An egg that survives a fall can be used again.
 …..A broken egg must be discarded.
 …..The effect of a fall is the same for all eggs.
 …..If an egg breaks when dropped, then it would break if dropped from a higher floor.
 …..If an egg survives a fall then it would survive a shorter fall.
 …..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.

 If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way.
 Drop the egg from the first-floor window; if it survives, drop it from the second floor window.
 Continue upward until it breaks. In the worst case, this method may require 36 droppings.
 Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work in all cases?
 The problem is not actually to find the critical floor,
 but merely to decide floors from which eggs should be dropped so that total number of trials are minimized.

 In this post, we will discuss solution to a general problem with n eggs and k floors. The solution is to try dropping an egg from every floor (from 1 to k) and recursively calculate the minimum number of droppings needed in worst case. The floor which gives the minimum value in worst case is going to be part of the solution.
 In the following solutions, we return the minimum number of trials in worst case; these solutions can be easily modified to print floor numbers of every trials also.

 1) Optimal Substructure:
 When we drop an egg from a floor x, there can be two cases (1) The egg breaks (2) The egg doesn’t break.

 1) If the egg breaks after dropping from xth floor, then we only need to check for floors lower than x with remaining eggs; so the problem reduces to x-1 floors and n-1 eggs
 2) If the egg doesn’t break after dropping from the xth floor, then we only need to check for floors higher than x; so the problem reduces to k-x floors and n eggs.

 Since we need to minimize the number of trials in worst case, we take the maximum of two cases. We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.

 k ==> Number of floors
 n ==> Number of Eggs
 eggDrop(n, k) ==> Minimum number of trials needed to find the critical
 floor in worst case.
 eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)):
 x in {1, 2, ..., k}}

 */
public class Set11EggDroppingPuzzle {


    public static void main(String[] args) {
        int n = 2;
        int k = 10;
        System.out.println(eggDropDP(2, 100));
    }

    private static int eggDrop(int n, int k) {

        /*
         Boundary Conditions
         If there are no floors, then trails needed, OR if there is one floor, one trail is need
         */
        if (k == 0 || k == 1)
            return k;

        //We need k trails for one egg and k floors
        if (n == 1)
            return k;

        int min = Integer.MAX_VALUE;
        int res;
        int x;

        //Consider all droppings from 1st floor to kth floor and return the minimum of these values plus 1;
        for (x = 1; x <= k; x++) {
            res = Math.max(eggDrop(n-1, x-1), eggDrop(n, k-x));
            if (res < min)
                min = res;
        }
        return min + 1;
    }

    /*
        Method2 : Dynamic Programming Solution
        Re-Computations of same subproblems can be avoided by constructing a temporary array eggFloor[][] in bottom up manner.
     */
    private static int eggDropDP(int n, int k) {

        int res, x;
        /*
            A 2D table where entry eggFloor[i][j] represents the minminum trails required for i egges and j floors
         */
        int eggFloor[][] = new int[n+1][k+1];

        //Boundary conditions
        //we always need j trails for one egg and j floors
        for(int j = 1; j <= k; j++)
            eggFloor[1][j] = j;

        //we need one trail for one floor and 0 trail for 0 floor
        for (int i = 1; i <= n; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        //Fill the rest of entries using optimal substructure property
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j<=k; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    res = 1 + Math.max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }

        return eggFloor[n][k];
    }



}
