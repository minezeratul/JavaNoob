package Chapter20.q4;

import java.util.Arrays;

public class Test4 {
     public static void main(String[] args){
         Point[] points = new Point[100];
         for (int i = 0; i < points.length; i++) {
             points[i] = new Point(Math.random() * 100, Math.random() * 100);
         }

         System.out.println("Sort on x-coordinates");
         Arrays.sort(points);
         for (int i = 0; i < points.length; i++) {
             System.out.println(points[i]);
         }

         System.out.println("Sort on y-coordinates");
         Arrays.sort(points, new CompareY());
         for (int i = 0; i < points.length; i++) {
             System.out.println(points[i]);
         }
     }
}
