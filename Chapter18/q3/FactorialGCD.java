package Chapter18.q3;

import java.util.Scanner;

public class FactorialGCD {
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int m = input.nextInt();
        System.out.print("Enter the second number: ");
        int n = input.nextInt();

        System.out.println("The GCD of " + m + " and " + n + " is " + gcd(m, n));
    }

    public static int gcd(int m, int n) {
        if (m % n == 0)
            return n;
        else
            return gcd(n, m % n);
    }
}
