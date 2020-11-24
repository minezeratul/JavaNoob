package chapter23.HW.q2ComparatorwAble;

import java.util.Arrays;
import java.util.Comparator;

public class Test2 {
    public static void main(String[] args) {
        Integer[] arr = {0,1,4,5,9,8,7,2,3,6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] arr2 = {0,1,4,5,9,8,7,2,3,6};
        mergeSort1(arr2, (o1, o2) -> { //返回负数,第一个参数放前面
            if (o1 > o2)  // default setting(increasing) : < return -1 / = return / > return 1
                return -1;

            return 0; //But now why decreasing? because two elements are different
        });

        System.out.println(Arrays.toString(arr2));

    }

    public static<E extends Comparable<E>> void mergeSort(E[] list) { //Comparable以降序调整array
        if (list.length > 1){
            E[] firstHalf = (E[])new Comparable[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[])new Comparable[secondHalfLength];
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, list);
        }
    }

    public static<E> void mergeSort1(E[] list , Comparator<? super E> comparator) { //Comparator一般以降序排列 ，可用o1 - o2 返回升序排列
        if (list.length > 1) {

            E[] firstHalf = (E[])new Object[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort1(firstHalf, comparator);

            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[])new Object[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort1(secondHalf, comparator);

            merge1(firstHalf , secondHalf , list , comparator);
        }
    }

    public static<E extends Comparable> void merge(E[] list1 , E[] list2 , E[] temp){
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1].compareTo(list2[current2]) < 0)
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
    }

    public static<E> void merge1(E[] list1 , E[] list2 , E[] temp ,Comparator<? super E> comparator){
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (comparator.compare(list2[current2] , list1[current1] ) < 0) // but if compare(list1 , list2) < 0
                temp[current3++] = list1[current1++];                    //it will be a decreasing list
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];

    }
}
