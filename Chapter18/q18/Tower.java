package Chapter18.q18;


import java.util.Scanner;

public class Tower {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of disks: ");
        int n = input.nextInt();

        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');

        System.out.println("The total number of moves is " + count);
    }

    static int count = 0;

    public static void moveDisks(int n, char fromTower,
                                 char toTower, char auxTower) {
        count++;
        if (n == 1)
            System.out.println("Move disk " + n + " from " +
                    fromTower + " to " + toTower);
        else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " +
                    fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }
}
