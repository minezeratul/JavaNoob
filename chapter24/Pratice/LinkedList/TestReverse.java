package chapter24.Pratice.LinkedList;

public class TestReverse {
    public static void main(String[] args) {
       LinkedListPratice list = new LinkedListPratice();
       list.add(5);
       list.add(4);
       list.add(3);
       list.add(2);
       list.add(1);
       System.out.println(list);

       Node temp = list.reverse(list.head);//list node -> temp node
       System.out.println(list);
       System.out.println(temp.next.element);
       list.show(temp);

        list.clear();
        for (int i = 0 ; i < 5 ; i++) {
            list.add(temp.element);
            temp = temp.next;
        }

        System.out.println();
        list.add(6);
        System.out.println(list);
    }
}
