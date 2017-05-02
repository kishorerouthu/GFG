package com.tutorial.gfg.arrays;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/**
 * Created by kishore on 2/5/17.
 */
public class LexiNextPermutation {

    static int numChar;
    static int curChar;
    static byte[] buffer = new byte[1024];
    static InputStream stream;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {

        stream = System.in;
        out = new PrintWriter(System.out);

        int t = readInt();
        while (t > 0) {
            String s = readLine();
            char c[] = s.toCharArray();
            String result = nextPermutation(c)? new String(c) : "no answer";
            out.println(result);
            t--;
        }

        out.flush();
        out.close();
    }

    private static void swap(char c[], int i, int j) {
        if (c[i] == c[j])
            return;

        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    private static int bsearch(char c[], int l, int r, int key) {
        int index = -1;
        while (l<=r) {
            int mid = (l + r)/2;
            if (c[mid] <= key)
                r = mid - 1;
            else {
                l = mid + 1;
                if (index == -1 || c[index] <= c[mid])
                    index = mid;
            }
        }
        return index;
    }

    private static void rev(char c[], int l, int r) {
        while (l<r) {
            swap(c, l, r);
            l++;
            r--;
        }
    }

    private static boolean nextPermutation(char c[]) {
        int len = c.length;
        int i = len - 2;
        while (i>=0 && c[i] >= c[i+1])
            --i;
        if(i<0)
            return false;
        else {
            int index = bsearch(c, i+1, len-1, c[i]);
            swap(c, i, index);
            rev(c, i+1, len-1);
            return true;
        }
    }



    private static int read() throws IOException {
        if (numChar <= curChar) {
            curChar = 0;
            numChar = stream.read(buffer);
            if (numChar <= 0) {
                return -1;
            }
        }
        return buffer[curChar++];
    }

    private static long readLong() throws IOException, InputMismatchException {
        int c = read();
        if (c == -1)
            throw new IOException();
        while (isSpaceChar(c)) {
            c = read();
        }
        boolean negative = false;
        if (c == '-') {
            negative = true;
            c = read();
        }
        long res = 0;
        while (!isSpaceChar(c)) {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += (c - '0');
            c = read();
        }
        if (negative)
            return -res;
        return res;
    }

    private static int readInt() throws IOException, InputMismatchException {
        return (int) readLong();
    }

    private static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\t' || c == '\r' || c == -1;
    }

    private static String readLine() throws IOException {
        StringBuilder buf = new StringBuilder ();
        int c = read ();
        while (c != '\n' && c != -1){
            if (c != '\r'){
                buf.appendCodePoint (c);
            }
            c = read ();
        }
        return buf.toString ();
    }

}
