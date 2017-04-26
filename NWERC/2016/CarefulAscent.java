package com.company;

import java.util.Scanner;

/**
 * Created by aa on 20/02/17.
 */
public class CarefulAscent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int numShields = scanner.nextInt();
        float[] array = new float[3 * numShields];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextFloat();
        }
        final float verticalSpeed = 1;

        float numerator = array[0];

        for (int i = 0; i < numShields; i++) {
            // in part
            numerator += (1 / array[i * 3 + 2]) * (array[i * 3 + 1] - array[i * 3]);
            // out part
            if (i + 1 < numShields) {
                numerator += (array[i * 3 + 3] - array[i * 3 + 1]);
            }
        }

        numerator += x - array[array.length - 2];
        float xspeed = numerator / y;
        System.out.println(xspeed);
    }
}
