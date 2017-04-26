package com.company;

import java.util.Scanner;

/**
 * Created by aa on 17/03/17.
 */
public class CamelCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.split("[A-Z]");
        System.out.println(words.length);
    }
}
