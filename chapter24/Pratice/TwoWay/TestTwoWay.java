package chapter24.Pratice.TwoWay;


public class TestTwoWay {
    public static void main(String[] args) {
        TwoWayLinkedList<Integer> list = new TwoWayLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(5 , 7);

        System.out.println(list);
        System.out.println(list.get(3));
        
        list.remove(4);
        System.out.println(list);
        
        System.out.println(list.contains(8));

        Node node = list.reverse(list.getHead());//list节点已经传给了node
        System.out.println(list);

        while (node != null){
            System.out.print(node.element + " ");
            node = node.next;
        }

        System.out.println("\n" + list);



    }
}
