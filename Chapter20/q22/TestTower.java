package Chapter20.q22;

import java.util.Scanner;
import java.util.Stack;

public class TestTower {
    static Stack<MyNode> stack = new Stack<MyNode>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int disk = input.nextInt();
        System.out.println("There are moves : ");
        moveDisks(disk ,'A', 'B', 'C');
    }

    public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
        stack.push(new MyNode(false, n , fromTower, toTower, auxTower));
        while (!stack.isEmpty()) {
            MyNode node = stack.pop();
            n = node.n;
            fromTower = node.fromTower;
            toTower = node.toTower;
            auxTower = node.auxTower;
            if (node.isLast) {
                System.out.println("Move disk " + n + " from " + node.fromTower + " to " + node.toTower);
            } else {
                if (n == 1)
                    System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
                else {
                    stack.push(new MyNode(false, n - 1, auxTower, toTower, fromTower));
                    stack.push(new MyNode(true, n, fromTower, toTower, auxTower));
                    stack.push(new MyNode(false, n - 1, fromTower, auxTower, toTower));
                }
            }
        }
    }

    static class MyNode {
        boolean isLast = false;
        int n;
        char fromTower;
        char toTower;
        char auxTower;

        MyNode(boolean isLast, int n, char fromTower, char toTower, char auxTower) {
            this.isLast = isLast;
            this.n = n;
            this.fromTower = fromTower;
            this.toTower = toTower;
            this.auxTower = auxTower;
        }
    }

}