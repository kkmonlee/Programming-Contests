package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aa on 27/01/17.
 */
public class Staircase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j >= n - 1) System.out.print("#");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
