package chapter24.Pratice.TwoWay;

public class TwoWayLinkedList<E> {
    private Node<E> head , tail ;
    private int size;

    public TwoWayLinkedList(){
        size = 0;
    }

    public TwoWayLinkedList(E[] newObjects){
        for (E newObject : newObjects)
            add(newObject);
    }

    public Node<E> reverse(Node head){
        if (head.next == null)
            return head;

        Node<E> last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        this.head = last; //which can reset the head
        return last;
    }

    public void add(E newObject){
        add(size , newObject);
    }

    public void add(int index , E element){
        if (index <= 0) {
            addFirst(element);
        }
        else if (index >= size) {
            addLast(element);
        }
        else {
            Node predator , successor;
            if (index < size - index){
                predator = head;
                for (int i = 1 ; i < index ; i++)
                    predator = predator.next;

                successor = predator.next;
            }
            else {
                successor = tail;
                for (int j = 1 ; j < size - index ; j++)
                    successor = successor.previous;

                predator = successor.previous;
            }

            size++;
            Node<E> current = new Node<>(element);
            current.previous = predator;
            current.next = successor;
            predator.next = current;
            successor.previous = current;

         /*   Node<E> current = head;
            for (int i = 1; i < index; i++) {//i doesnt need to be 0 , when 0 it turns to be addfirst()
                current = current.next;
            }
            Node<E> temp = current.next; // [current] -> [temp]
            current.next = new Node<>(element);// [current] -> [New element] ->[temp]
            (current.next).next = temp; //[current] -> [New element] -> [temp]
            size++;

            temp.previous = current.next;
            current.next.previous = current; */
        }
    }

    public void addFirst(E element){
        Node<E> newNode = new Node<>(element);
        newNode.next = head;//[newNode] -> [newNode.next = old head]
        head = newNode;//[new head] -> [newNode.next]
        size++;

        if (tail == null)
            tail = head;

        if (head != tail)
            head.next.previous = head;
    }

    public void addLast(E element){
        Node<E> newNode = new Node<>(element);

        Node<E> temp = tail;

        if (tail == null)
            head = tail = newNode;
        else {
            tail.next = newNode;//[tail] -> [tail.next = null => newNode]
            tail = tail.next;//[tail = tail.next =  newNode]
        }

        size++;
        tail.previous = temp;//[temp = old tail] -> [newNode]
    }

    public void remove(int index){
        checkIndex(index);

        if (index == 0)
            removeFirst();
        else if (index == size - 1)
            removeLast();
        else {
            Node<E> predator, successor;
            if (index < size - index) {
                predator = head;
                for (int i = 1; i < index; i++)
                    predator = predator.next;

                successor = predator.next.next;
            } else {
                successor = tail;
                for (int j = 1; j < size - index - 1; j++)
                    successor = successor.previous;

                predator = successor.previous.previous;

            }
            size--;
            predator.next = successor;
            successor.previous = predator;

           /* Node<E> previous = head;

            for (int i = 1 ; i < index ; i++)
                previous = previous.next;

            Node<E> current = previous.next;//[previous] -> [the removed one] -> [removed.next]
            previous.next = current.next;//[previous] -> [removed.next]
            current.next.previous = previous;

            size-- ;

            return current.element; */
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

    public E get(int index) {
        checkIndex(index);

        Node<E> current = head;
        if (index + 1 < size - index) {
            for (int i = 0; i < index; i++)
                current = current.next;
        }
        else {
            current = tail;
            for (int j = 0 ; j < size - index ; j++)
                current = current.previous;
        }

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
        while (temp != null)
        {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        if (head == null || head.next == null)
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

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail(){
        return tail;
    }
}

