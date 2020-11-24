package chapter23.HW.q1;

import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
        Integer[] arr = {0,1,4,5,9,8,7,2,3,6};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] arr2 = {9 , 8 ,7 ,6 ,5  , 3 ,1 , 2, 4 , 0};
        bubbleSort(arr2, (o1, o2) -> {
            if (o1 > o2)
                return o1;

            return 0;
        });
        System.out.println(Arrays.toString(arr2));

    }
    
    public static<E extends Comparable<E>>void bubbleSort(E[] list){
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;

            for (int i = 0; i < list.length - k; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }

    public static<E> void bubbleSort(E[] list , Comparator<? super E> comparator){
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;

            for (int i = 0; i < list.length - k; i++) {
                if (comparator.compare(list[i],list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }
}
