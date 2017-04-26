package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aa on 27/01/17.
 */
public class AVeryBigSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        long result = 0;

        long A[] = new long[N];

        for (int i = 0; i <= N - 1; i++) {
            A[i] = in.nextLong();
        }

        for (int i = 0; i <= N - 1; i++) {
            result += A[i];
        }

        //System.out.println(Arrays.toString(A));
        System.out.println("Result: " + result);
    }
}
