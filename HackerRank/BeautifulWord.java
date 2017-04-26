package com.company;

import java.util.Scanner;

/**
 * Created by aa on 14/04/17.
 */
public class BeautifulWord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String w = in.next();

        if (isBeautiful(w))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    private static boolean isVowel(char c) {
        String restricted = "aeiouy";
        for (char c_ : restricted.toCharArray()) {
            if (c == c_) return true;
        }
        return false;
    }

    private static boolean isBeautiful(String w) {
        for (int i = 0;i < w.length() - 1; i++) {
            if (w.charAt(i) == w.charAt(i + 1))
                return false;
            if (isVowel(w.charAt(i)) && isVowel(w.charAt(i + 1)))
                return false;
        }
        return true;
    }
}
