package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aa on 27/02/17.
 */
public class DesignerPDFViewer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object[] heights = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray();
        String word = scanner.nextLine();

        int maxHeight = 0;
        for (int i = 0; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 'a';
            int height = (int) heights[charIndex];
            if (height > maxHeight) {
                maxHeight = height;
            }
        }

        long square = word.length() * maxHeight;
        System.out.println(square);
        scanner.close();
    }
}
