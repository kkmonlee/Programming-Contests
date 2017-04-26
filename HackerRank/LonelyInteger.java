package com.company;

/**
 * Created by aa on 14/03/17.
 */
public class LonelyInteger {

    static int lonelyInteger(int[] arr) {
        int[] count = new int[101];
        for (int i = 0; !(arr.length <= i); i++) {
            if (arr[i] >= 0)
                if (arr[i] > 100) {
                    continue;
                }
                count[arr[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 1) {
                continue;
            }
            return i;
        }
        return 0;
    }

}
