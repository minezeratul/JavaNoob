package chapter24.Pratice.Priority;

import chapter24.Pratice.ArrayList.ArrayListPratice;

public class PriorityQueuePratice<E extends Comparable> {
    private heapLife<E> heap = new heapLife<E>();

    public void enqueue(E newObject) {
        heap.add(newObject);
    }

    public E dequeue() {
        return heap.remove();
    }

    public int size() {
        return heap.getSize();
    }

    @Override
    public String toString(){
        return "PriorityQueue: " + heap.toString();
    }

    private class heapLife<E extends Comparable> {
        ArrayListPratice<E> list = new ArrayListPratice<E>();

        public heapLife() {
        }

        public heapLife(E[] newObjects) {
            for (int i = 0; i < newObjects.length; i++)
                add(newObjects[i]);
        }

        public void add(E newObject) {
            list.add(newObject);
            int currentIndex = list.size() - 1;

            while (currentIndex > 0) {
                int parentIndex = (currentIndex - 1) / 2;

                if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
                    E temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(parentIndex));
                    list.set(parentIndex, temp);
                } else
                    break;

                currentIndex = parentIndex;
            }
        }

        public E remove() {
            if (list.size() == 0)
                return null;

            E removedObject = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);

            int currentIndex = 0;
            while (currentIndex < list.size()) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;

                if (leftChildIndex >= list.size()) break;
                int maxIndex = leftChildIndex;
                if (rightChildIndex < list.size()) {
                    if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0)
                        maxIndex = rightChildIndex;//right is the max , so swap
                }

                if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                    E temp = list.get(maxIndex);
                    list.set(maxIndex, list.get(currentIndex));
                    list.set(currentIndex, temp);
                    currentIndex = maxIndex;
                } else
                    break;
            }
            return removedObject;
        }

        public int getSize() {
            return list.size();
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }
}

