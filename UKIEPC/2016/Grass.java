package com.company;

import java.util.Scanner;

/**
 * Created by aa on 27/02/17.
 */
public class Grass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float C = scanner.nextFloat();
        int L = scanner.nextInt();
        float totalArea = 0;

        for (int i = 1; i <= L; i++) {
            float x = scanner.nextFloat();
            float y = scanner.nextFloat();
            totalArea += x * y;
        }

        totalArea *= C;

        System.out.printf("%.6f", totalArea);
    }
}
