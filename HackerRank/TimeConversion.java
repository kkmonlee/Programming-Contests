package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aa on 27/01/17.
 */
public class TimeConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inTime = in.nextLine();
        StringBuffer sb = new StringBuffer();

        int hour = 0;
        hour = Integer.parseInt(inTime.substring(0, 2));

        if (inTime.substring(8, 10).equals("PM")) {
            if (hour != 12) hour += 12;
        } else if (hour == 12) hour = 0;
        if (hour < 10) sb.append(0);

        sb.append(hour);
        sb.append(inTime.substring(2, 8));
        System.out.println(sb.toString());
    }
}
