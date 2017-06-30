package com.css.gfg.arrays;

import java.util.Arrays;

/**
 * Problem Statement :
 *
 * Check whether Arithmetic Progression can be formed from the given array
 * Given an array of n integers. The task is to check whether an arithmetic progression
 * can be formed using all the given elements. If possible print “Yes”, else print “No”.
 *
 * Any sequence with this property is called an arithmetic progression,
 * or AP for short. a, a + d, a + 2d, a + 3d, a + 4d, ... a, a + d, a + 2d, a + 3d, ... where the n-th term is a + (n − 1)d
 * Created by kishore on 15/2/17.
 */
public class ArithmeticProgression {

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{12, 40, 11, 20};
        Arrays.sort(arr);
        String ans = isArithmeticProgression(arr) ? "Yes" : "No";
        System.out.println(ans);
    }

    private static boolean isArithmeticProgression(Integer arr[]) {
        int n = arr.length;
        int d = arr[1] - arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i-1] != d)
                return false;
        }
        return true;

    }
}


