package com.company;

import java.util.Scanner;

/**
 * Created by aa on 20/02/17.
 */
public class IdentifyingMapTiles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int x = 0;
        int y = 0;

        for (char c : input.toCharArray()) {
            x = 2 * x;
            y = 2 * y;

            if (c == '1' || c == '3') {
                x += 1;
            }

            if (c == '2' || c == '3') {
                y += 1;
            }
        }

        System.out.printf("%d %d %d", input.length(), x, y);
    }
}
