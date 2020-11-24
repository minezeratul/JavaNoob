package Chapter18.q1;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer of any size: ");
        String numberString = input.nextLine();

        BigInteger bigNumber = new BigInteger(numberString);

        System.out.println(factorial(bigNumber));
    }

    public static BigInteger factorial(BigInteger i) {
        if (i.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return i.multiply(factorial(i.subtract(BigInteger.ONE)));
    }
}
