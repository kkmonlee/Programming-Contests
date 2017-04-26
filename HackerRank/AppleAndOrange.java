package com.company;

import java.util.Scanner;

/**
 * Created by aa on 18/04/17.
 */
public class AppleAndOrange {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in .nextInt();
        int t = in .nextInt();
        int a = in .nextInt();
        int b = in .nextInt();
        int m = in .nextInt();
        int n = in .nextInt();
        int[] apple = new int[m];
        int applesIn = 0, orangesIn = 0;
        for (int apple_i = 0; apple_i < m; apple_i++) {
            apple[apple_i] = in .nextInt();
            int pos = (apple[apple_i] + a);
            if (pos >= s && pos <= t) applesIn++;

        }
        int[] orange = new int[n];
        for (int orange_i = 0; orange_i < n; orange_i++) {
            orange[orange_i] = in .nextInt();
            int pos = (orange[orange_i] + b);
            if (pos >= s && pos <= t) orangesIn++;
        }
        System.out.println(applesIn + "\n" + orangesIn);
    }
}
