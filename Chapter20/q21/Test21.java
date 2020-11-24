package Chapter20.q21;

import java.util.Comparator;

public class Test21 {
    public static void main(String[] args) {
        GeometricObject[] list = {new Circle(5)   , new Rectangle(4,5),
                                  new Circle(5.5) , new Rectangle(2.4 ,5) ,
                                  new Circle(0.5) , new Rectangle(4 , 65),
                                  new Circle(4.5) , new Rectangle(4.4, 1),
                                  new Circle(6.5) , new Rectangle(4,5)
                                 };

        selectionSort(list , new GeometricObjectComparator());
        for (GeometricObject g :list)
            System.out.println(g.getArea() + " ");

    }
    public static <E> void selectionSort(E[] list , Comparator<? super E> comparator) {
        boolean needNextPass = true;
        for (int i = 1; i < list.length && needNextPass; i++) {
            needNextPass = false;
            for (int k = 0; k < list.length - i; k++) {
                if (comparator.compare(list[k], list[k + 1]) > 0) {
                    E temp = list[k];
                    list[k] = list[k + 1];
                    list[k + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }

}
