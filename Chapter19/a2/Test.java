package Chapter19.a2;

public class Test {
    public static void main(String[] args){
        GenericStack<String> stack = new GenericStack<String>();
        stack.push("Jonas");
        stack.push("Martha");
        stack.push("Tanhaus");

        System.out.println(stack);

        System.out.println(stack.search("Tanhaus"));
        System.out.println(stack.search("Jonas"));
        System.out.println(stack.search("Martha"));

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());



    }

    static class GenericStack<E> extends java.util.ArrayList<E> {

        public boolean isEmpty() {
            return super.isEmpty();
        }

        public int getSize() {
            return size();
        }

        public Object peek() {
            return get(getSize() - 1);
        }

        public Object pop() {
            Object o = get(getSize() - 1);
            remove(getSize() - 1);
            return o;
        }

        public Object push(E o) {
            add(o);
            return o;
        }

        public int search(Object o) {
            return indexOf(o);
        }


        @Override
        public String toString() {
            return "stack: " + getSize();
        }
    }
}
