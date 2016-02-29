public class SubString {
    public static int subStr(String haystack, String needle) {
        if (haystack == null || needle == null) 
            return -1;
        int hLen = haystack.length();
        int nLen = needle.length();
        for (int i = 0; i <= hLen - nLen; i++) {
            int j;
            for(j = 0; j < nLen; j++) {
                if (needle.charAt(j) != haystack.charAt(i+j))
                    break;
            }
            if (j == nLen)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(subStr("hello world", "hello"));
        System.out.println(strStr("hello world", "hello"));
        System.out.println(strStr("hello world", "helle"));

    }
    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null)
            return -1;
        int hLen = haystack.length();
        int nLen = needle.length();
        for(int i = 0; i <= hLen-nLen; i++){
            int j = 0;
            for(; j<nLen; j++){
                if(needle.charAt(j)!=haystack.charAt(i+j))
                    break;
            }
            if(j == nLen)
                return i;
        }
        return -1;
    }
}
