package Chapter22.q11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many points are in the set? ");
        int numberOfPoints = input.nextInt();

        double[][] p = new double[numberOfPoints][2];
        System.out.print("Enter " + p.length + " points: ");
        for (int i = 0; i < p.length; i++)
            for (int j = 0; j < p[i].length; j++)
                p[i][j] = input.nextDouble();

        ArrayList<MyPoint> list = getConvexHull(p);

        System.out.print("The convex hull is ");
        for (MyPoint myPoint : list) {
            System.out.print("(" + myPoint.x + ", " + myPoint.y + ") ");
        }
    }

    /**
     * Return the points that form a convex hull
     */
    public static ArrayList<MyPoint> getConvexHull(double[][] points) {
        // Create MyPoint objects for points
        ArrayList<MyPoint> p = new ArrayList<>();
        for (double[] point : points) p.add(new MyPoint(point[0], point[1]));

        placeP0(p);

        for (int i = 0; i < points.length; i++)
            p.get(i).setRightMostLowestPoint(p.get(0));

        Collections.sort(p);

        p = MyPoint.discardTies(p); // If two points have the same angle, discard the one that is closer to p0

        if (p.size() < 3)
            return null;

        ArrayList<MyPoint> stack = new ArrayList<>(); // We use ArrayList rather than java.util.Stack, because the algorithm needs to access the top two elements
        stack.add(p.get(0));
        stack.add(p.get(1));
        stack.add(p.get(2));

        int i = 3;
        while (i < p.size()) {
            MyPoint t2 = stack.get(stack.size() - 1);
            MyPoint t1 = stack.get(stack.size() - 2);

            if (MyPoint.whichSide(t1.x, t1.y, t2.x, t2.y, p.get(i).x, p.get(i).y) >= 0) { // on the right of the line from t1 to t2
                // pop the top element off the stack
                stack.remove(stack.size() - 1);
            } else {
                // push a new element to the stack
                stack.add(p.get(i));
                i++;
            }
        }

        return stack;
    }

    /**
     * Place the rightmost lowest point as the first element in p
     */
    private static void placeP0(ArrayList<MyPoint> p) {
        int rightMostIndex = 0;
        double rightMostX = p.get(0).x;
        double rightMostY = p.get(0).y;

        for (int i = 1; i < p.size(); i++) {
            if (rightMostY < p.get(i).y) {
                rightMostY = p.get(i).y;
                rightMostX = p.get(i).x;
                rightMostIndex = i;
            } else if (rightMostY == p.get(i).y && rightMostX < p.get(i).x) {
                rightMostX = p.get(i).x;
                rightMostIndex = i;
            }
        }

        // Swap p.get(rightMostIndex) with p.get(0)
        if (rightMostIndex != 0) {
            MyPoint temp = p.get(0);
            p.set(0, p.get(rightMostIndex));
            p.set(rightMostIndex, temp);
        }
    }
}
