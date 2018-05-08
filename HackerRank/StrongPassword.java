import java.util.Scanner;

/**
 * Created by aa2676 on 08 May 2018.
 */
public class StrongPassword {

    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        boolean numCount = false, lowCount = false, upCount = false, specialCount = false;

        for (char c : password.toCharArray()) {
            if (numbers.indexOf(c) != -1) numCount = true;
            if (lower_case.indexOf(c) != -1) lowCount = true;
            if (upper_case.indexOf(c) != -1) upCount = true;
            if (special_characters.indexOf(c) != -1) specialCount = true;
        }

        int changes = 0;

        if (!numCount) ++changes;
        if (!lowCount) ++changes;
        if (!upCount) ++changes;
        if (!specialCount) ++changes;

        return Math.max(changes, 6 - n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}
