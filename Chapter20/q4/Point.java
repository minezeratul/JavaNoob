package Chapter20.q4;

public class Point implements Comparable<Point> {
    double x;
    double y;

    Point(){
        this(1,1)
        ;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p2) {
        if (this.x < p2.x)
            return -1;
        else if (this.x == p2.x) {
            if (this.y < p2.y)
                return -1;
            else if (this.y == p2.y)
                return 0;
            else
                return 1;
        } else
            return 1;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

