package chapter24.Pratice.Priority;

import chapter24.Pratice.Priority.PriorityQueuePratice;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueuePratice queue = new PriorityQueuePratice();
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);
    }
}
