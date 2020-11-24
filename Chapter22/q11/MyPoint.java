package Chapter22.q11;

import java.util.ArrayList;

public class MyPoint implements Comparable<MyPoint> {
    public double x, y;
    MyPoint rightMostLowestPoint;

    MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setRightMostLowestPoint(MyPoint p) {
        rightMostLowestPoint = p;
    }

    public boolean equals(MyPoint o) {
        return x == o.x && y == o.y;
    }

    @Override
    public int compareTo(MyPoint o) {
        if (o == rightMostLowestPoint && y == rightMostLowestPoint.y) return 1;

        double status = whichSide(rightMostLowestPoint.x, rightMostLowestPoint.y, o.x, o.y, this.x, this.y);
        if (status < 0) // Left side of the line from rightMostLowestPoint to o, please note we are using the Java coordinate system. y increases downward
            return 1;
        else if (status == 0)
            return 0;
        else
            return -1;
    }

    public static double whichSide(double x0, double y0, double x1, double y1, double x2, double y2) {
        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }


    /*
     If two points have the same angle, discard the one that is closer to p0
     */
    public static ArrayList<MyPoint> discardTies(ArrayList<MyPoint> p) {
        ArrayList<MyPoint> list = new ArrayList<MyPoint>();
        list.add(p.get(0));

        int i = 1;
        while (i < p.size()) {
            double d = distance(p.get(0).x, p.get(0).y, p.get(i).x, p.get(i).y);
            int indexOfLargest = i;
            int k = i + 1;
            while (k < p.size() && p.get(i).compareTo(p.get(k)) == 0) {
                if (d < distance(p.get(0).x, p.get(0).y, p.get(k).x, p.get(k).y)) {
                    d = distance(p.get(0).x, p.get(0).y, p.get(k).x, p.get(k).y);
                    indexOfLargest = k;
                }
                k++;
            }

            list.add(p.get(indexOfLargest));
            i = k;
        }

        return list;
    }
}
