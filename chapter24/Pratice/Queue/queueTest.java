package chapter24.Pratice.Queue;

public class queueTest {
    public static void main(String[] args) {
        QueuePratice queue = new QueuePratice();
        queue.enqueue(5);;
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        System.out.println(queue);

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.size());
    }
}
