package Chapter19.a9;

import java.util.ArrayList;

public class Test9 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(8);
        list.add(2);
        list.add(9);
        list.add(4);
        list.add(5);
        for (Integer integer : list)
            System.out.print(integer + " ");

        sort(list);
        System.out.println();
        for (Integer integer : list)
            System.out.print(integer + " ");
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list){ //looks like insertionSort
        E currentMin;
        int currentMinIndex;

        for (int i = 0; i < list.size() - 1; i++) {
            currentMin = list.get(i);
            currentMinIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (currentMin.compareTo(list.get(j)) > 0) {
                    currentMin = list.get(j);
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                list.set(currentMinIndex, list.get(i));
                list.set(i, currentMin);
            }
        }

    }
}
