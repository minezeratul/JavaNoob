package chapter24.Pratice.ArrayList;

public class ArrayListPratice<E extends Comparable>{
    public static final int INITIAL_CAPACITY = 16;
    private E[] data;
    int size = 0 ;

    public ArrayListPratice(){
        this(INITIAL_CAPACITY);
    }

    public ArrayListPratice(int capacity){
        if (capacity < 0)
            try {
                throw new Exception("Wrong input ");
            } catch (Exception e) {
                e.printStackTrace();
            }

        data = (E[]) new Comparable[capacity];
    }

    public ArrayListPratice(E[] newObjects){
        for (int i = 0 ; i < newObjects.length ; i++)
            add(newObjects[i]);
    }

    public void add(E newObject) {
        ensureCapacity();
        data[size++] = newObject;
    }

    public void add(int index , E element){
        checkIndex(index);
        ensureCapacity();

        for (int i = size - 1 ; i >= index ; i--)
            data[i + 1] = data[i];

        data[index] = element;

        size++;
    }

    public E remove(int index){
        checkIndex(index);
        E element = data[index];

        for (int j = index ; j < size - 1 ;j++)
            data[j] = data[j + 1];

        data[size - 1] = null;
        size--;

        return element;
    }

    public E set(int index , E element){
        checkIndex(index);
        E old = data[index];
        data[index] = element;

        return old;
    }

    @Override
    public String toString() {
        if (size == 0)
            return "no elements";

        else {
            StringBuilder result = new StringBuilder("[");

            for (int i = 0; i < size; i++) {
                result.append(data[i]);
                if (i < size - 1) result.append(", ");
            }

            return result.toString() + "]";
        }
    }

    /** Trims the capacity to current size */
    public void trimToSize() {
        if (size != data.length) {
            E[] newData = (E[])(new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        } // If size == capacity, no need to trim
    }

    public void clear(){
        data = (E[])new Object[INITIAL_CAPACITY];
        size = 0 ;
    }

    public boolean contains(E element){
        for (int i = 0 ; i < size ; i++)
            if (data[i] == element)
                return true;

            return false;
    }

    private void ensureCapacity(){
        if (size >= data.length){
            E[] newData = (E[])new Object[size * 2 + 1];
            System.arraycopy(newData ,0 ,data ,0 , size);
            data = newData;
        }
    }


    public int size() {
        return size;
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    public void checkIndex(int index){
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index : " + index + " is out of bound ");
    }

    public java.util.Iterator<E> iterator() {
        return new ArrayListIterator();
    }


    private class ArrayListIterator implements java.util.Iterator<E> {
        private int current = 0; // Current index

        @Override
        public boolean hasNext() {
            return (current < size);
        }

        @Override
        public E next() {
            return data[current++];
        }

        @Override
        public void remove() {
            ArrayListPratice.this.remove(current);
        }

    }
}


