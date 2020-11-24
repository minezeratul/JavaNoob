package chapter24.Pratice.LinkedList;

public class LCTest {
    public static void main(String[] args) {
        LCLinkedList list = new LCLinkedList();
        list.addAtTail(6);
        list.addAtTail(7);
        System.out.println(list.get(0));
        System.out.println(list.get(1));

        ListNode temp = list.head;
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

}
