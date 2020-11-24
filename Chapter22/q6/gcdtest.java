package Chapter22.q6;

public class gcdtest {
    public static void main(String[] args) {
     long startTime = System.currentTimeMillis();
     gcd1(234 , 7);
        long endTime = System.currentTimeMillis();
     long result = endTime - startTime;
     System.out.println(result);

     
    }

    public static int gcd1(int m, int n) {
        int gcd = 1;

        if (m % n == 0) return n;

        for (int k = n / 2; k >= 1; k--) {
            if (m % k == 0 && n % k == 0) {
                gcd = k;
                break;
            }
        }

        return gcd;
    }

    public static int gcd2(int m, int n) {
        if (m % n == 0)
            return n;
        else
            return gcd2(n, m % n);
    }
    
}
