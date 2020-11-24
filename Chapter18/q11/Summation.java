package Chapter18.q11;

import java.util.Scanner;

public class Summation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int i = input.nextInt();
        System.out.println( " " + sumDigits(i));

    }

    public static int sumDigits(long n) {
        int result = 0;

        if (n != 0) {
            result = sumDigits(n / 10) + (int)(n % 10);
        }

        return result;
    }
}
