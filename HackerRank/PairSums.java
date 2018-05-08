package HackerRank;

import java.util.Scanner;

 /**
 * Created by aa2676 on 07 May 2018.
 */
public class PairSums {

    static long please(int[] A, int n) {
        long max = Long.MIN_VALUE;

        int i = 0;
        while (i < n) {
            long value = 0, sum = 0;
            for (int j = i; j < n; ++j) {
                value += sum * A[j];
                sum += A[j];
                max = Math.max(value, max);
            }
            ++i;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }

        System.out.println(please(A, n));

        in.close();
    }
}
