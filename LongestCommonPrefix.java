public class LongestCommonPrefix {
    public static String getLongestCommonPrefix(String[] words) {
       if (words == null || words.length == 0)
          return "";
       // Assume the first word is the longest prefix
       StringBuilder longestPrefix = new StringBuilder(words[0]);
       for (int i = 1; i < words.length;i++) {
          // Remove letters from the longest prefix as long as the current words starts with it
          while (!words[i].startsWith(longestPrefix.toString())) {
              longestPrefix.deleteCharAt(longestPrefix.length() - 1);
          }
       }
       return longestPrefix.toString();
    }

    public static void main(String[] args) throws Exception  {
        System.out.println(getLongestCommonPrefix(new String[] {}));
        System.out.println(getLongestCommonPrefix(new String[] {"cataract", "catar", "cat"}));
        System.out.println(getLongestCommonPrefix(new String[] {"cataract"}));
        System.out.println(getLongestCommonPrefix(new String[] {"cat","rat"}));
        System.out.println(getLongestCommonPrefix(null));
    }
}
