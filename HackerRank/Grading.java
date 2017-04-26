package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by aa on 18/04/17.
 */
public class Grading {

    private static ArrayList<Integer> getMultiples() {
        ArrayList<Integer> aList = new ArrayList<>();
        int x;
        for (int i = 1; i < 101; i++) {
            x = 5 * i;
            aList.add(x);
        }

        return aList;
    }

    private static int getNextMultiple(ArrayList<Integer> a, int n) {
        int nearestMult = -1;

        for (Integer i : a) {
            if (i > n) {
                nearestMult = i;
                break;
            }
        }

        return nearestMult;
    }

    private static int roundUp(int n) {
        return (n + 4) / 5 * 5;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];

        for (int grades_i = 0; grades_i < n; grades_i++) {
            grades[grades_i] = in.nextInt();
        }

        ArrayList<Integer> multiples = getMultiples();

        for (int i = 0; i < grades.length; i++) {
            if (getNextMultiple(multiples, grades[i]) - grades[i] < 3 && grades[i] >= 38) {
                grades[i] = roundUp(grades[i]);
            }
        }

        for (int grade : grades) {
            System.out.println(grade);
        }
    }
}
