package chapter24.Pratice.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class TestLinked {
    public static void main(String[] args) {
        LinkedListPratice list = new LinkedListPratice();

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list + " and size is " + list.size());//[1 , 2 , 3]

        list.add(-1 , 9);
        list.add(6 , 8);
        System.out.println(list);
        System.out.println(list.get(0));

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.remove();
        }

        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("\n" + list);//[4 , 1 , 2 , 3]

        list.remove(3);
        System.out.println(list);//[4 , 1 , 2]

        list.removeLast();
        System.out.println(list);//[4 , 1]

        list.addLast(5);
        System.out.println(list);//[4 , 1 , 5]

        list.remove(1);
        System.out.println(list);//[4 , 5]

        list.set(2 , 6);//no such index
        System.out.println(list);//still [4 , 5]

        System.out.println(list.contains(4));
    }

}
