package chapter23.HW.q3;

import java.util.Arrays;
import java.util.Comparator;

public class Test3 {
    public static void main(String[] args) {
        Integer[] arr = {6, 5, 7, 8, 2, 9, 3, 1, 4};
        System.out.println("Comparable:");
        quickSort1(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] arr2 = {6, 5, 7, 8, 2, 9, 3, 1, 4};
        System.out.println("Comparator:");
        quickSort2(arr2 , (o1, o2) -> { //Comparator in quickSort needs all situations
            if (o1 > o2)
                return 1;
            else if (o1 < o2)
                return -1;
            else
                return 0;
        });
        System.out.println(Arrays.toString(arr2));

    }

    private static <E extends Comparable<E>> void quickSort1(E[] list) {
        quickSort1(list, 0, list.length - 1);
    }


    private static <E extends Comparable<E>> void quickSort1(E[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition1(list, first, last);
            quickSort1(list, first, pivotIndex - 1);
            quickSort1(list, pivotIndex + 1, last);
        }
    }

    private static <E extends Comparable<E>> int partition1(E[] list, int first, int last) {
        E pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low) {

            while (low <= high && list[low].compareTo(pivot) <= 0) {
                low++;
            }

            while (low <= high && list[high].compareTo(pivot) > 0) {
                high--;
            }

            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high].compareTo(pivot) >= 0) {
            high--;
        }

        if (pivot.compareTo(list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }


    public static <E> void quickSort2(E[] list, Comparator<? super E> comparator) {
        quickSort2(list, 0, list.length - 1, comparator);
    }

    private static <E> void quickSort2(E[] list, int first, int last, Comparator<? super E> comparator) {
        if (last > first) {
            int pivotIndex = partition2(list, first, last, comparator);
            quickSort2(list, first, pivotIndex - 1, comparator);
            quickSort2(list, pivotIndex + 1, last, comparator);
        }
    }

    private static <E> int partition2(E[] list, int first, int last, Comparator<? super E> comparator) {
        E pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low) {
            while (low <= high && comparator.compare(list[low], pivot) <= 0) {
                low++;
            }

            while (low <= high && comparator.compare(list[high], pivot) > 0) {
                high--;
            }

            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && comparator.compare(list[high], pivot) >= 0) {
            high--;
        }

        if (comparator.compare(pivot, list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }
}
