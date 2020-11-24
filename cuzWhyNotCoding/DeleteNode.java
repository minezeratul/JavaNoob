package cuzWhyNotCoding;

public class DeleteNode {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  //给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
  //返回删除后的链表的头节点!!!
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null)
            return null;

        if(head.val == val)
            return head.next;



        ListNode temp = head;
        while(temp.next.val != val && temp.next != null){
            temp = temp.next;
        }

        temp.next = temp.next.next ;

        return head;//necessary

    }
}
