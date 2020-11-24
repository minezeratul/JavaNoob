package Chapter19.a10;

import java.util.ArrayList;

public class Test10 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(max(list));
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list){
        E currentMax = list.get(0);

        for (int i = 1; i < list.size(); i++)
            if (currentMax.compareTo(list.get(i)) < 0)
                currentMax = list.get(i);

        return currentMax;
    }
}
