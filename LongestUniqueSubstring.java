import java.util.Map;
import java.util.HashMap;

public class LongestUniqueSubstring {
    private int getLUS(String inputString) {
        int[] charArray = new int[256];
        int m = 0, longest = 0;
        for (int i = 0; i < inputString.length();i++) {
            // current character already present
            int currentChar = inputString.charAt(i) - 'a';
            m = Math.max(charArray[currentChar] + 1, m);
            charArray[currentChar] = i;
            // current character not present in window
            longest = Math.max(longest, i - m + 1);
        }
    }
}
