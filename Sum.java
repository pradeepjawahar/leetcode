public class Sum {
    public static int add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum;
        for (int i=s1.length()-1,j=s2.length() -1; i >= 0 || j >= 0 || carry > 0; i--,j--) {
            sum = 0;
            sum += (i>=0)? s1.charAt(i) - '0' : 0;
            sum += (j>=0)? s2.charAt(j) - '0' : 0;
            sum += carry;
            
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
        }
       return Integer.parseInt(sb.reverse().toString()); 
    }
    
    public static void main(String[] args) {
        System.out.println(add("21" ,"45"));
        System.out.println(add("21" ,"-45"));
    } 
}
