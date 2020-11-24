package chapter24.Pratice.Stack;

public class ArrayStack<E> {
    public static final int INITIAL_CAPACITY = 16;
    private E[] stack ;
    int size = 0;


    public ArrayStack(){
        this(INITIAL_CAPACITY);
    }

    public ArrayStack(int capacity){
        stack = (E[])new Object[capacity];
    }




    public void ensureCapacity(){
        if (size >= stack.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(stack, 0, newData, 0, size);
            stack = newData;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(stack[i]);
            if (i < size - 1) result.append(", ");
        }

        return result.toString() + "]";
    }
}
