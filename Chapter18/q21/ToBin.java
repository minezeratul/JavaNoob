package Chapter18.q21;

import java.util.Scanner;

public class ToBin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal integer: ");
        int decimal = input.nextInt();
        System.out.println(decimal + " is binary " + decimalToBinary(decimal));
    }

    public static String decimalToBinary(int value) {
        if (value == 0)
            return "";
        else
            return decimalToBinary(value / 2) + value % 2;
    }
}
