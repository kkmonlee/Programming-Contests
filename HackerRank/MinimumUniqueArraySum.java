package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
i * Created by aa on 20/02/17.
 */
public class MinimumUniqueArraySum {

    public static void main(String[] args) throws IOException {
        /*Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = getMinimumUniqueSum(_arr); //<-

        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();*/

        int[] array = {1,1,1,2,2,2};
        System.out.println(getMinimumUniqueSum(array));
    }

    static int getMinimumUniqueSum(int[] arr) {
        ArrayList<Integer> array = new ArrayList<>();
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            array.add(arr[i]);
        }

        int sum;
        hash.put(0, array.get(0));
        sum = hash.get(0);
        for (int i = 1; i < array.size(); i++)
            for (int j = 1; j <= arr.length; j++)
                if (!hash.containsValue(array.get(i))) {
                    hash.put(i, array.get(i));
                    sum += hash.get(i);
                    break;
                } else {
                    array.set(i, array.get(i) + 1);
                }

        return sum;
    }
/*    static int getMinimumUniqueSum(int[] arr) {

        int total = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (j != i && arr[j] == temp) {
                    arr[j]++;
                    j = 0;
                }
            }


            total += temp;
            System.out.println(temp);
        }

        return total;
    }*/

}
