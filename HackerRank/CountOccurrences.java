public class CountOccurrences {
    public static long countOccurrences(String s, long n) {
        long length = s.length();
        long fullRepetitions = n / length;
        long remainingChars = n % length;

        // Count occurrences of 'a' in the full repetitions
        long totalCount = fullRepetitions * countOccurrencesInString(s, length);

        // Count occurrences of 'a' in the remaining characters
        totalCount += countOccurrencesInString(s, remainingChars);

        return totalCount;
    }

    private static long countOccurrencesInString(String s, long length) {
        long count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        return count;
    }
}