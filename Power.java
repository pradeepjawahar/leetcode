public class Power {
    private static double pow(double x, int n) {
        double result = 1.0;
        for(int i = n; i != 0; i/=2,x*=x) {
            if ( i % 2 != 0)
              result *= x;
        }

        return n < 0 ? 1.0 / result : result;
    }

    public static void main(String[] args) {
        System.out.println(pow(2.0, 2));
        System.out.println(pow(2.0, -2));
    }
}
