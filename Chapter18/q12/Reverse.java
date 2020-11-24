package Chapter18.q12;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        reverseDisplay(s);

    }

    public static void reverseDisplay(String value) {
        reverseDisplay(value, value.length() - 1);
    }

    public static void reverseDisplay(String value, int high) {
        if (high >= 0) {
            System.out.print(value.charAt(high));
            reverseDisplay(value, high - 1);
        }
    }
}
