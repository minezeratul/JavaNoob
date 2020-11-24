package Chapter22.q6;

public class tEST6 {
    public static void main(String[] args) {
        final int INDEX = 47;
        int[] numbers = new int[INDEX];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 2; i < INDEX; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        System.out.printf("%25d %5d %5d %5d %5d %5d" , 40 , 41 ,42 ,43 ,44 ,45);
        System.out.println("\n----------------------------------------------------------------------");
        System.out.print("Listing 22.3 GCD\t");

        long[] executionTime = new long[6];

        for (int i = 40; i <= 45; i++) {
            long startTime = System.currentTimeMillis();
            gcd1(numbers[i], numbers[i + 1]);
            executionTime[i - 40] = System.currentTimeMillis() - startTime;
        }

        for (int i = 0; i <= 5; i++) {
            System.out.printf("%5d " , executionTime[i]);
        }

        System.out.print("\nListing 22.3 GCDEuclid");

        for (int i = 40; i <= 45; i++) {
            long startTime = System.currentTimeMillis();
            gcd2(numbers[i], numbers[i + 1]);
            executionTime[i - 40] = System.currentTimeMillis() - startTime;
        }

        for (int i = 0; i <= 5; i++) {
            System.out.print("\t" + executionTime[i]);
        }

    }

    public static long fib(long n) {
        long n0 = 0;
        long n1 = 1;
        long n2 = 2;

        if (n == 0)
            return n0;
        else if (n == 1)
            return n1;
        else if (n == 2)
            return n2;

        for (int i = 3; i <= n; i++) {
            n0 = n1;
            n1 = n2;
            n2 = n1 + n0;
        }
        return n2;

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
