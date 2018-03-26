package com.css.gfg.strings;

/**
 * @author Kishore Routhu on 14/1/18 6:45 PM.
 *
 * Write a program to print all permutations of a given String
 *
 * Ref# src/main/resources/Permutation.gif
 */
public class Permutations {

    static int counter = 1;
    public static void main(String[] args) {
        final String s = "123";
        final int n = s.length();
        permute(s, 0, n-1);
    }

    private static void permute(String str, int l, int r) {

        if (l == r) {
            System.out.println(counter + ":" + str);
            counter++;
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l+1, r);
            }
        }
    }

    private static String swap(String str, int l, int i) {
        char[] chars = str.toCharArray();
        char temp = chars[l];
        chars[l] = chars[i];
        chars[i] = temp;
        return String.valueOf(chars);
    }
}
