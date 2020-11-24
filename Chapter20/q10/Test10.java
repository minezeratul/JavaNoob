package Chapter20.q10;

import java.util.Arrays;
import java.util.PriorityQueue;


public class Test10 {
    public static void main(String[] args) {
        PriorityQueue<String> queue1 = new PriorityQueue<String>(
                Arrays.asList(new String[]{"George", "Jim", "John", "Blake", "Kevin", "Michael"}));

        PriorityQueue<String> queue2 = new PriorityQueue<String>(
                Arrays.asList(new String[] {"George", "Katie", "Kevin", "Michelle", "Ryan"}));

      /*  queue1.addAll(queue2);
        System.out.println("The union of the two priority queue is " + queue1);

        queue1 = new PriorityQueue<String>(
                Arrays.asList(new String[]{"George", "Jim", "John", "Blake", "Kevin", "Michael"}));

        queue1.removeAll(queue2);
        System.out.println("The difference of the two priority queue is " + queue1);

        queue1 = new PriorityQueue<String>(
                Arrays.asList(new String[]{"George", "Jim", "John", "Blake", "Kevin", "Michael"}));

        queue1.retainAll(queue2);
        System.out.println("The intersection of the two priority queue is " + queue1); */

        PriorityQueue queue3 = new PriorityQueue();
        queue3.addAll(queue1);
        queue3.addAll(queue2);
        System.out.println("The union of the two priority queue is " + queue3);
        queue3.clear();

        queue3.addAll(queue1);
        queue3.removeAll(queue2);
        System.out.println("The difference of the two priority queue is " + queue3);
        queue3.clear();

        queue3.addAll(queue1);
        queue3.retainAll(queue2);
        System.out.println("The intersection of the two priority queue is " + queue3);

    }
}
