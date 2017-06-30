package com.css.gfg.arrays;

import java.util.Arrays;

/**
 * Created by kishore on 14/2/17.
 */

public class FourElementSum {


    public static void main(String[] args) {
        int a[] = new int[]  {10, 2, 3, 4, 5, 9, 7, 8};
        int X = 23;
        int n = a.length;
        int size = (n*(n-1))/2;
        Pair aux[] = new Pair[size];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                Pair pair = new Pair(i, j, a[i] + a[j]);
                aux[k] = pair;
                k++;
            }
        }

        Arrays.sort(aux);

        int i = 0;
        int j = size - 1;
        int totalSum = 0;
        while (i < size && j >= 0) {
            totalSum = aux[i].getSum() + aux[j].getSum();
            if(totalSum == X && noCommon(aux[i], aux[j])) {
                System.out.println(a[aux[i].getFirst()] + "," + a[aux[i].getSec()] + "," + a[aux[j].getFirst()] + "," +a[aux[j].getSec()]);
                return;
            } else if (totalSum < X) {
                i++;
            } else {
                j--;
            }
        }
    }

    private static boolean noCommon(Pair pair1, Pair pair2) {
        if (pair1.getFirst() == pair2.getFirst() || pair1.getFirst() == pair2.getSec() ||
                pair1.getSec() == pair2.getFirst() || pair1.getSec() == pair2.getSec())
            return false;
        return true;
    }

    private static class Pair implements Comparable<Pair> {
        int first;
        int sec;
        int sum;

        public Pair(int first, int sec, int sum) {
            this.first = first;
            this.sec = sec;
            this.sum = sum;
        }

        public int getFirst() {
            return first;
        }

        public int getSec() {
            return sec;
        }

        public int getSum() {
            return sum;
        }

        public int compareTo(Pair o) {
            return this.sum - o.getSum();
        }
    }
}
