import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by aa2676 on 08 May 2018.
 */
public class WeatherForecastQuality {
    // Complete the totalForecastInaccuracy function below.
    static int totalForecastInaccuracy(int[] t, int[] f) {
        // Return the sum of the weather forecast inaccuracies across all 7 days.
        int sum = 0;
        for (int i = 0; i < t.length; ++i) {
            sum += Math.abs(t[i] - f[i]);
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[] t = new int[7];

        String[] tItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < 7; tItr++) {
            int tItem = Integer.parseInt(tItems[tItr]);
            t[tItr] = tItem;
        }

        int[] f = new int[7];

        String[] fItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int fItr = 0; fItr < 7; fItr++) {
            int fItem = Integer.parseInt(fItems[fItr]);
            f[fItr] = fItem;
        }

        int result = totalForecastInaccuracy(t, f);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
