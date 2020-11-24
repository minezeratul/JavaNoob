package Chapter20.q12;

import java.util.PriorityQueue;

public class MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {
    public MyPriorityQueue() {
        super();
    }

    @Override
    public boolean offer(E o) {
        return super.offer(o);
    }

    @Override
    public E peek() {
        return super.peek();
    }

    @Override
    public E poll() {
        return super.poll();
    }

    public Object clone() throws CloneNotSupportedException {
        MyPriorityQueue<E> queue = new MyPriorityQueue<E>();

        for (E e: this) {
            queue.offer(e);
        }
        return queue;
    }

}
