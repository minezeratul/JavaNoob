package Chapter20.q12;

public class Test12 {
    public static void main(String[] args) {
        MyPriorityQueue<String> queue = new MyPriorityQueue<String>();
        queue.offer("Red");
        queue.offer("Green");
        queue.offer("Blue");

        MyPriorityQueue<String> queue1 = null;
        try {
            queue1 = (MyPriorityQueue<String>)(queue.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.print(queue1);
    }
}
