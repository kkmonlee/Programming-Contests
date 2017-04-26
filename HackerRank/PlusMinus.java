package com.company;

import java.util.Scanner;

/**
 * Created by aa on 27/01/17.
 */
public class PlusMinus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float positives = 0;
        float zeroes = 0;
        float negatives = 0;

        int N = in.nextInt();
        int A[] = new int[N];

        for (int i = 0; i <= N - 1; i++) {
            A[i] = in.nextInt();
            if (A[i] > 0) positives++;
            if (A[i] < 0) negatives++;
            if (A[i] == 0) zeroes++;
        }

        float positiveFrac = positives / N;
        float zeroesFrac = zeroes / N;
        float negativesFrac = negatives / N;

        /*System.out.printf("Positives = %1.1f\n" +
                "Negatives = %1.1f\n" +
                "Zeroes = %1.1f\n\n", positives, negatives, zeroes);*/

        /*System.out.printf("Positive fraction = %1.6f\n" +
                "Negatives fraction = %1.6f\n" +
                "Zeroes fraction = %1.6f\n\n", positiveFrac, negativesFrac, zeroesFrac);*/

        System.out.printf("%1.6f\n%1.6f\n%1.6f", positiveFrac, negativesFrac, zeroesFrac);
    }
}
