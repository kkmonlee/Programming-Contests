package com.company;

/**
 * Created by aa on 14/03/17.
 */
public class LongestEvenLength {
    static String longestEvenWord(String sentence) {
        String[] splitted = sentence.split(" ");
        String longestEvenWord = "00";
        String longestOddWord = "";

        for (String s : splitted) {
            if (s.length() > longestOddWord.length()) {
                longestOddWord = s;
                if (s.length() % 2 == 0) {
                    longestEvenWord = s;
                } else {
                    longestOddWord = s;
                }
            }
        }

        if (longestEvenWord.equals("00")) {
            return longestEvenWord;
        } else if (longestEvenWord.length() < longestOddWord.length()) {
            return longestEvenWord;
        }
        return longestOddWord;
    }

    static String foo(String sentence) {
        String[] splitted = sentence.split(" ");
        String longestEven = "";

        for (String s : splitted) {
            if ((s.length() % 2 == 0) && (longestEven.length() < s.length())) {
                longestEven = s;
            }
        }

        if (longestEven.equals("")) {
            return "00";
        }
        return longestEven;
    }
}
