package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aa on 27/01/17.
 */
public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int A[][] = new int[N][N];

        for (int i = 0; i <= N - 1; i++) {
            for (int j = 0; j <= N - 1; j++) {
                A[i][j] = in.nextInt();
                //System.out.printf("i: %d, j: %d\n", i, j);
            }
        }

        int primaryDiag = 0, secondaryDiag = 0;

        for (int i = 0; i <= N - 1; i++) {
            primaryDiag += A[i][i];
        }

        int w = 0;
        for (int i = N - 1; i >= 0; i--) {
            secondaryDiag += A[i][w];
            w++;
        }

        int difference = Math.abs(primaryDiag - secondaryDiag);

        /*System.out.println("Primary Diagonal = " + primaryDiag);
        System.out.println("Secondary Diagonal = " + secondaryDiag);
        System.out.println("Absolute Difference = " + difference);
        System.out.println(Arrays.deepToString(A));*/
        System.out.printf("%d", difference);
    }

}
