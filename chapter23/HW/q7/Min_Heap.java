package chapter23.HW.q7;

import java.util.ArrayList;

public class Min_Heap {
    public static void main(String[] args) {
        MinHeap<Integer> heap = new MinHeap<Integer>(new Integer[]{8, 9, 2, 3, 4, 1, 5, 6, 7});
        while (heap.getSize() > 0)
            System.out.print(heap.remove() + " ");
        
        MinHeap heap2 = new MinHeap();
        heap2.add(1);
        heap2.add(2);
        heap2.add(4);
        heap2.add(5);
        heap2.add(3);
        System.out.println("\n" + heap2);
    }
}

class MinHeap<E extends Comparable> {
    private ArrayList<E> list = new ArrayList<E>();

    MinHeap(){
    }

    MinHeap(E[] objects){
        for (int i = 0 ; i < objects.length ; i++)
            add(objects[i]);
    }

    void add(E object){
        list.add(object);
        int currentIndex = list.size() - 1;

        while(currentIndex > 0){
            int parentIndex = (currentIndex - 1) / 2;

            if (list.get(currentIndex).compareTo(list.get(parentIndex)) < 0){//difference
                E temp = list.get(currentIndex);
                list.set(currentIndex , list.get(parentIndex));
                list.set(parentIndex , temp);
            }
            else
                break;

            currentIndex = parentIndex;
        }

    }

    E remove(){
        if (list.size() == 0)
            return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the minimum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) > 0) { //difference
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the minimum
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) > 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
            else
                break; // The tree is a heap
        }

        return removedObject;

    }

    public int getSize() {
        return list.size();
    }

    public String toString(){
        return list.toString();
    }
}