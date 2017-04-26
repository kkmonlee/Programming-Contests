package com.company;

import java.util.Scanner;

/**
 * Created by aa on 14/03/17.
 */
public class ReduceTheFraction {

    static String[] ReduceFraction(String[] fractions) {
        for (int i = 0; i < fractions.length; i++) {
            String[] splitted = fractions[i].split("/");
            int numerator = Integer.parseInt(splitted[0]);
            int denom = Integer.parseInt(splitted[1]);

            int gcd = gcd(numerator, denom);
            if (gcd == 1) {
                continue;
            } else {
                int newNumerator = numerator / gcd;
                int newDenom = denom / gcd;
                String fract = newNumerator + "/" + newDenom;
                fractions[i] = fract;
            }
        }
        return fractions;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


}
