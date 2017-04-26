package com.company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aa on 27/02/17.
 */
public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object[] numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Long::parseLong).toArray();
        Arrays.sort(numbers);
        long minSum = 0;
        long maxSum = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            minSum += (long) numbers[i];
            maxSum += (long) numbers[i + 1];
        }

        System.out.println(minSum + " " + maxSum);
        scanner.close();
    }
}
