package chapter24.Pratice.Queue;

import chapter24.Pratice.LinkedList.LinkedListPratice;

public class QueuePratice<E> {
    LinkedListPratice<E> list = new LinkedListPratice();

    public void enqueue(E element){
        list.addLast(element);
    }

    public void dequeue(){
        list.removeFirst();
    }

    public int size(){
       return list.size();
    }

    @Override
    public String toString(){
        return "Queue: " + list.toString();
    }
}
