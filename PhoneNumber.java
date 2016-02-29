import java.util.List;
import java.util.LinkedList;
public class PhoneNumber {
    private static String[] KEYS = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits == null || digits.length() == 0)
            return null;
         combination("",digits,0,result);
         return result;
    }

    private static void combination(String prefix, String digits, int offset, List<String> result) {
        if (offset >= digits.length()) {
            result.add(prefix);
            return;
        }

        String letters = KEYS[digits.charAt(offset) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, result);
        }
    }

    public static void main(String[] args) throws Exception {
        printList(letterCombinations("456"));
    }

    private static void printList(List<String> array) {
        for (String item : array) {
            System.out.println(item);
        }
    }
}
