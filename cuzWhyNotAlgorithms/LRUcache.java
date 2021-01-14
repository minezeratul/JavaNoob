package cuzWhyNotAlgorithms;


import java.util.HashMap;

public class LRUcache {//LinkedHashMap
    private class Node {
        public int key, val;
        public Node next, prev;

        Node(){
        }

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }

    /*
    private class DoubleList{
        Node head , tail;
        int size;

        DoubleList(){
            size = 0;
            head = tail = null ;

        }

        public void addFirst(Node x){
            if (head == null)
                head = tail = x;
            else{
                head.prev = x ;
                x.next = head;
                head = x;
            }
            size++;
        }

        public void remove(Node x){
            if (head == null)
                return;

            if (x == head)
                head = head.next;
            else if(x == tail)
                removeLast();
            else {
                Node cur = x;
                cur.prev.next = cur.next;
            }


            size--;
        }

        public Node removeLast(){
            if (tail == null)
                return null;

            Node cur = tail;
            tail.prev.prev.next = tail.prev;
            tail = tail.prev;

            size--;

            return cur;
        }

        public int size(){
            return size;
        }
    } */

    private HashMap<Integer, Node> cache = new HashMap<Integer, Node>();
    private int size;
    private int capacity;
    private Node head, tail;

    public LRUcache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            Node newNode = new Node(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                Node tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.val = value;
            moveToHead(node);
        }
    }


    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    @Override /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node current = head.next;
        for (int i = 0; i < size; i++) {
            result.append("(" + current.key + " , " + current.val + ")");
            current = current.next;
            if (current != tail) {
                result.append(", "); // Separate two elements with a comma
            }
            else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }
}

