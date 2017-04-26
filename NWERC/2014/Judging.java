package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by aa on 20/03/17.
 */
public class Judging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<String> first = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            first.add(scanner.next());
        }

        List<String> second = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            second.add(scanner.next());
        }

        Collections.sort(first);
        Collections.sort(second);

        int totalCount = 0;
        int ptr = 0;
        int ptr2 = 0;
        while (ptr < n && ptr2 < n) {
            if (first.get(ptr).equals(second.get(ptr2))) {
                totalCount++;
                ptr++;
                ptr2++;
            } else if (first.get(ptr).compareTo(second.get(ptr2)) < 0) {
                ptr++;
            } else {
                ptr2++;
            }
        }

        System.out.println(totalCount);
    }
}
