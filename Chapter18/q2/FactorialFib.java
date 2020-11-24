package Chapter18.q2;

import java.util.Scanner;

public class FactorialFib {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int i = input.nextInt();
        System.out.println("The fibonacci(" + i + " ) is " + fib(i));
    }

    public static long fib(int n) {
        int f0 = 0, f1 = 1, currentFib;

        if (n == 0) return 0;
        if (n == 1) return 1;

        for (int i = 2; i <= n; i++) {
            currentFib = f0 + f1;
            f0 = f1;
            f1 = currentFib;
        }

        return f1;
    }
}
