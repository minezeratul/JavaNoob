package chapter24.Pratice.LinkedList;


import java.util.Iterator;

public class LinkedListPratice<E> {
    Node<E> head , tail , successor = null;
    private int size;

    public LinkedListPratice(){
        size = 0;
    }

    public LinkedListPratice(E[] newObjects){
        for (E newObject : newObjects)
            add(newObject);
    }

    public Node<E> reverse(Node head){
/*
        Node previous = null;
        Node current = head;
        if(head == null)
            return null;

        while (current != null) {
            Node nextTemp = current.next;
            current.next = previous;
            previous = current;
            current = nextTemp;
        }
        return previous;
*/

        if (head.next == null)
           return head;

         Node<E> last = reverse(head.next);
         head.next.next = head;
         head.next = null;
         this.head = last; //which can reset the head
         return last;


    }

    public Node<E> reverseN(Node head , int num){
        if (num == 1) {
            successor = head.next;
            return head;
        }

        Node last = reverseN(head.next , num - 1);
        head.next.next = head;
        head.next = successor ;
        return last;
    }

    public void add(E newObject){
       add(size , newObject);
    }

    public void add(int index , E element) {
        if (index <= 0){
            addFirst(element);
        }
        else if (index >= size) {
            addLast(element);
        }
        else {
            Node<E> current = head;//we cannot remove head node , so we need a pointer
            for (int i = 1; i < index; i++) {//i doesnt need to be 0 , when 0 it turns to be addfirst()
                current = current.next;
            }
            Node<E> temp = new Node<>(element); // [current] -> [temp]
            temp.next = current.next;// [current] -> [New element] ->[temp]
            current.next = temp; //[current] -> [New element] -> [current.next]
            size++;
        }
    }

    public void addFirst(E element){
        Node<E> newNode = new Node<>(element);
        newNode.next = head;//[newNode] -> [newNode.next = old head]
        head = newNode;//[new head] -> [newNode.next]
        size++;

        if (tail == null)
            tail = head;
    }

    public void addLast(E element){
        Node<E> newNode = new Node<>(element);

        if (tail == null)
            head = tail = newNode;
        else {
            tail.next = newNode;//[tail] -> [tail.next = null => newNode]
            tail = tail.next;//[tail = tail.next =  newNode]
        }

        size++;
    }

    public E remove(int index){
        checkIndex(index);

        if (index == 0)
            return removeFirst();
        else if (index == size - 1)
            return removeLast();
        else {
            Node<E> previous = head;

            for (int i = 1 ; i < index ; i++)
                previous = previous.next;

            Node<E> current = previous.next;//[previous] -> [the removed one] -> [removed.next]
            previous.next = current.next;//[previous] -> [removed.next]
            size-- ;

            return current.element;
        }
        
    }

    public E removeFirst(){
        if (size == 0)
            return null;
        else{
            Node<E> temp = head; // [old head] -> [head.next[
            head = head.next; // [old head] -> [new head]
            size--;

            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    public E removeLast(){
        if (size == 0)
            return null;
        else if (size == 1){
            Node<E> temp = head;
            head = tail = null; // list become empty
            size = 0;
            return temp.element;
        }
        else {
           Node<E> current = head;

            for (int i = 0; i < size - 2; i++) {// why size - 2 ?
                current = current.next;
            }

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;

            return temp.element;
        }
    }

    public E set(int index , E element){
        if (index < 0 || index >= size)
            return null;

        if (index == 0)
            head.element = element;
        if (index == size)
            tail.element = element;

        Node<E> current = head;
        for(int j = 0 ; j < index ; j++){
            current = current.next;
        }
        current.element = element;

        return current.element;
    }

    public int size(){
        return size;
    }

    public void clear(){
        size = 0;
        head = tail = null;
    }

    public boolean contains(E element){
        Node<E> current = head;
        if (current == null)
            return false;

        for (int i = 0 ; i < size ; i++) {
            if (current.element == element)
                return true;

            current = current.next;
        }

        return false;
    }

    public E get(int index){
        checkIndex(index);

        Node<E> current = head;
        for (int i = 0 ; i < index ; i++)
            current = current.next;

        return current.element;
    }

    public E getFirst(){
        if (size == 0)
            return null;
        else
            return head.element;
    }

    public E getLast(){
        if (size == 0)
            return null;
        else
            return tail.element;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public void show(Node temp){
        while (temp != null){
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        if (head == null)
            return "[]";

        Node<E> current = head;
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator<E> implements Iterator<E>{
        Node<E> current = (Node<E>) head;

        int index;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E temp = current.element;
            current = current.next;
            return temp;
        }

        @Override
        public void remove() {
            System.out.print(removeFirst() + " ");
        }
    }

}

