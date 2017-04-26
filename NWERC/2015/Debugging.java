import java.util.Arrays;
import java.util.Scanner;

/**

 * Created by aa on 20 February 2017.

 */
public class Debugging {
    static long[] time;
    static long r;
    static long p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split(" ");

        int n = Integer.parseInt(inputArray[0]);
        r = Long.parseLong(inputArray[1]);
        p = Long.parseLong(inputArray[2]);

        time = new long[n + 1];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;
        time[1] = 0;

        recurse(n);

        System.out.println(time[n]);
    }

    static void recurse(int i) {
        int s = (int) Math.sqrt(i);
        // check number of print statements

        for (int j = 1; j <= s; j++) {
            int blockLength = 1 + (i - 1) / (j + 1);
            if (time[blockLength] == Long.MAX_VALUE) {
                recurse(blockLength);
            }

            time[i] = Math.min(time[i], r + p * j + time[blockLength]);
        }

        // k is number of lines per code block after splitting

        for (int k = 1; k <= s; k++) {
            if (time[k] == Long.MAX_VALUE) {
                recurse(k);
            }
            time[i] = Math.min(time[i], r + p * (i - 1) / k + time[k]);
        }
    }

    /*static long recurse(int n) {

        if (memory[numOfLines] == Long.MAX_VALUE) {

            for (int i = 2; i <= numOfLines; i++) {

                memory[numOfLines] = Math.min(memory[numOfLines], (i - 1) * timeToPrintf + timeToCompile +

                    recurse((numOfLines + i - 1) / i));

            }

        }



        return memory[numOfLines];

    }*/
} 
