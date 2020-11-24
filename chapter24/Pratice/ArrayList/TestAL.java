package chapter24.Pratice.ArrayList;

import java.util.Iterator;

public class TestAL {
    public static void main(String[] args) {
        ArrayListPratice alp = new ArrayListPratice();
        alp.add(1);
        alp.add(2);
        alp.add(3);
        alp.add(4);
        System.out.println(alp);

        alp.remove(2);
        System.out.println(alp);

        System.out.println( alp.contains(4) );

        alp.add(3 , 6);
        System.out.println(alp);//if it is index 4 , it will pop Outofbound

        alp.set(3, 5);
        System.out.println(alp); //alp[3] = 6 => 5 ;

        Iterator iterator = alp.iterator();

        while (iterator.hasNext()) // the same method as alp.clear();
            iterator.remove();

        System.out.println("\n" + alp);


    }
}
