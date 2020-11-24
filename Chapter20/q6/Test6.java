package Chapter20.q6;

import java.util.Iterator;
import java.util.LinkedList;

public class Test6 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < 100000; i++)
            list.add(i);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++)
            list.get(i);

        long endTime = System.currentTimeMillis();
        System.out.println("Travese time using index is " + (endTime - startTime));

        int x = 0 ;
        startTime = System.currentTimeMillis();
        for (int i: list) {
            x = i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("Travese time using foreach is " + (endTime - startTime));

        int y = 0;
        Iterator it = list.iterator();
        startTime = System.currentTimeMillis();
        while (it.hasNext()){
            y = (int) it.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Travese time using iterator is " + (endTime - startTime));

    }
}
