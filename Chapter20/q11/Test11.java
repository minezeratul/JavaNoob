
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test11 {
    public static void main(String[] args) throws FileNotFoundException {

        GenericStack<Character> stack = new GenericStack<>();

        Scanner input = new Scanner(new File(args[0]));

        try {
            while (input.hasNext()) { 
                String s = input.nextLine();

                StringTokenizer tokens = new StringTokenizer(s, "[](){}", true);

                while (tokens.hasMoreTokens()) {
                    String token = tokens.nextToken().trim();
                    if (token.length() == 0)
                        continue;
                    else if (token.charAt(0) == '[') {
                        stack.push(']');
                    } else if (token.charAt(0) == '{') {
                        stack.push('}');
                    } else if (token.charAt(0) == '(') {
                        stack.push(')');
                    } else if (token.charAt(0) == ']' ||
                            token.charAt(0) == '}' ||
                            token.charAt(0) == ')') {
                        char ch = ((Character) (stack.pop())).charValue();
                        if (ch != token.charAt(0)) {
                            System.out.println("Exit 1: Incorrect grouping pairs");
                            System.exit(1);
                        }
                    }
                }
            }

            if (!stack.isEmpty()) {
                System.out.println("Exit 2: Incorrect grouping pairs");
                System.exit(2);
            }
        } catch (Exception ex) {
            System.out.println("Exit 3: Incorrect grouping pairs");
        }

        System.out.println("Correct grouping pairs");

    }

      static class GenericStack<E> {
        private java.util.ArrayList<E> list = new java.util.ArrayList<>();

        public int getSize() {
            return list.size();
        }

        public E peek() {
            return list.get(getSize() - 1);
        }

        public void push(E o) {
            list.add(o);
        }

        public E pop() {
            E o = list.get(getSize() - 1);
            list.remove(getSize() - 1);
            return o;
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        @Override
        public String toString() {
            return "stack: " + list.toString();
        }

    }

}


