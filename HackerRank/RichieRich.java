package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aa on 17/03/17.
 */
public class RichieRich {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        char[] s = number.toCharArray();

        if (n == 1) {
            if (k > 0) {
                System.out.println(9);
                System.exit(0);
            } else {
                System.out.println(number);
                System.exit(0);
            }
        }

        boolean possible = true;
        boolean[] changed = new boolean[n];
        for (int i = 0; i < n; i++) {
            changed[i] = false;
        }

        for (int i = 0; i < number.length() / 2; i++) {
            if (s[i] != s[n - i - 1]) {
                if (k > 0) {
                    if (s[i] > s[n - i - 1]) {
                        s[n - i - 1] = s[i];
                        changed[n - i - 1] = true;
                    } else {
                        s[i] = s[n - i - 1];
                        changed[i] = true;
                    }
                    k--;
                } else {
                    possible = false;
                }
            }
        }

        if (!possible) {
            System.out.println("-1");
            System.exit(0);
        }

        for (int i = 0; i < number.length() / 2; i++) {
            if (k == 0) {
                break;
            }

            if (s[i] != '9') {
                if (changed[i] || changed[n - i - 1]) {
                    s[i] = '9';
                    s[n - i - 1] = '9';
                    k--;
                } else {
                    if (k >= 2) {
                        s[i] = '9';
                        s[n - i - 1] = '9';
                        k -= 2;
                    }
                }
            }
        }

        if (n % 2 == 1 && k >= 1) {
            s[n / 2] = '9';
        }

        String x = new String(s);

        System.out.println(x);
    }
}
