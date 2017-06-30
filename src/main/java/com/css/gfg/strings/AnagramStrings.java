package com.css.gfg.strings;

/**
 * Created by Kishore Routhu on 10/6/17 11:45 AM.
 *
 * ProblemStatement : Check whether two strings are anagram of each other
 * Write a function to check whether two given strings are anagram of each other or not.
 * An anagram of a string is another string that contains same characters, only the order of characters can be different.
 * For example, “abcd” and “dabc” are anagram of each other.
 */

public class AnagramStrings {

    public static void main(String[] args) {

        String s1 = "test";
        String s2 = "ttes ";
        System.out.println(areAnagram(s1, s2));

    }


    /*
        This method assumes that the set of possible characters in both strings is small.
        In the following implementation, it is assumed that the characters are stored using 8 bit and there can be 256 possible characters.
        1) Create count arrays of size 256 for both strings. Initialize all values in count arrays as 0.
        2) Iterate through every character of both strings and increment the count of character in the corresponding count arrays.
        3) Compare count arrays. If both count arrays are same, then return true.
     */
    private static boolean areAnagram(String s1, String s2) {
        int NO_OF_CHARS = 256;
        int count1[] = new int[NO_OF_CHARS];
        int count2[] = new int[NO_OF_CHARS];

        char str1[] = s1.toCharArray();
        char str2[] = s2.toCharArray();

        int i;
        for (i = 0; i < s1.length(); i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

   /*     if ((str1[i] | str2[i]) == 0)
            return false;*/

        //compare count arrays
        for (i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }
}
