import java.io.*;
import java.util.*;

public class Palindrome {
    public static boolean isPalindrome(String inputText) {
        String phrase = inputText.toLowerCase();
        phrase = phrase.replaceAll("[^\\p{IsAlnum}]", "");

        if (phrase == null || phrase.length() == 0) {
            return false;
        }
        // String of size 1 is a palindrome
        if (phrase.length() == 1) {
            return true;
        }
        int begin = 0;
        int end = phrase.length() - 1;
        char[] cString = phrase.toCharArray();
        while (begin++ < end--) {
            if (cString[begin] != cString[end]) {
                return false;
            }
            //begin++;
            //end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";
        String test3 = "ccacc";
        String test4 = "a";
        String test5 = "bb";
        String test6 = "ccc";
        System.out.println(isPalindrome(test1));
        System.out.println(isPalindrome(test2));
        System.out.println(isPalindrome(test3));
        System.out.println(isPalindrome(test4));
        System.out.println(isPalindrome(test5));
        System.out.println(isPalindrome(test6));
    }
}
