package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aa on 14/04/17.
 */
public class AccurateSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();

        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int[] a = new int[n];

            for (int a_i = 0; a_i < n; a_i++) {
                a[a_i] = in.nextInt();
            }

            if (isSorted(a, ifSwappable(a))) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    private static boolean[] ifSwappable(int[] a) {
        boolean[] booleans = new boolean[a.length - 1];

        Arrays.fill(booleans, false);

        int k = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (diff(a[i], a[i + 1])) {
                booleans[i] = true;
            }
        }

        return booleans;
    }

    private static boolean isSorted(int[] a, boolean[] bools) {

        for (int i = 0; i < a.length - 1; i++) {
            if (bools[i]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean diff(int a, int b) {
        return Math.abs(a - b) == 1;
    }
}
