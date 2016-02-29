public class Strobogrammatic {
    public static boolean isStrobogrammatic(String num) {
        for (int i=0, j=num.length()-1; i <= j; i++, j--)
            if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("69"));
    }
}
