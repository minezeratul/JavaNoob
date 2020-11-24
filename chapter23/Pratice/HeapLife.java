package chapter23.Pratice;

import java.util.ArrayList;
import java.util.Arrays;

public class HeapLife {
    public static void main(String[] args) {
        Integer[] arr = {5 ,2 ,9 ,3 ,8 ,4 ,0 ,1 ,6 ,7 };
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    public static <E extends Comparable<E>> void heapSort(E[] list){
        Heap<E> heap = new Heap<>();

        // Add elements to the heap
        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }
}

class Heap<E extends Comparable>{
    private ArrayList<E> list = new ArrayList<>();

    Heap(){
    }

    Heap(E[] objects){
        for (int i = 0 ; i < objects.length ; i++)
            list.add(objects[i]);
    }

    void add(E object){
         list.add(object);
         int currentIndex = list.size() - 1 ;

         while (currentIndex > 0){
             int parentIndex = (currentIndex - 1) / 2;

             if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
                 E temp = list.get(currentIndex);
                 list.set(currentIndex , list.get(parentIndex));
                 list.set(parentIndex , temp);
             }
             else
                 break;

             currentIndex = parentIndex;
         }
    }

    E remove() {
        if (list.size() == 0)
            return null;

        E removeObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            //find the maximum
            if (leftChildIndex >= list.size()) break;
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            //swap the current
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else
                break;
        }
        return removeObject;
     }
}
