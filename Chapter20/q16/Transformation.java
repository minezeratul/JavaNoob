package Chapter20.q16;

import java.util.ArrayList;
import java.util.StringTokenizer;

class MyStack {
    private ArrayList<Object> list = new ArrayList<Object>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(getSize() - 1);
    }

    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        list.add(o);
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }
}


public class Transformation {
     public static void main(String[] args){
         if (args.length != 1) {
             System.out.println("Usage: java Transformation \"expression\"");
             System.exit(1);
         }

         String expression = "";
         for (int i = 0; i < args.length; i++) {
             expression += args[i];
         }

         try {
             System.out.println(infixToPostfix(expression));
         }
         catch (Exception ex) {
             System.out.println("Wrong expression");
         }

     }
    public static String infixToPostfix(String expression) {
        String s = "";

        MyStack operandStack = new MyStack();

        MyStack operatorStack = new MyStack();

        StringTokenizer tokens = new java.util.StringTokenizer(expression, "()+-/*%", true);

        // Phase 1: Scan tokens
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim(); // Extract a token
            if (token.length() == 0) { // Blank space
                continue; // Back to the while loop to extract the next token
            }
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek().equals('+') ||
                                operatorStack.peek().equals('-') ||
                                operatorStack.peek().equals('*') ||
                                operatorStack.peek().equals('/')
                        )) {
                    s += operatorStack.pop() + " ";
                }

                // Push the + or - operator into the operator stack
                operatorStack.push(new Character(token.charAt(0)));
            }
            else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                // Process all *, / in the top of the operator stack
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek().equals('*') ||
                                operatorStack.peek().equals('/')
                        )) {
                    s += operatorStack.pop() + " ";
                }

                // Push the * or / operator into the operator stack
                operatorStack.push(new Character(token.charAt(0)));
            }
            else if (token.trim().charAt(0) == '(') {
                operatorStack.push(new Character('(')); // Push '(' to stack
            }
            else if (token.trim().charAt(0) == ')') {
                // Process all the operators in the stack until seeing '('
                while (!operatorStack.peek().equals('(')) {
                    s += operatorStack.pop() + " ";
                }

                operatorStack.pop(); // Pop the '(' symbol from the stack
            }
            else { // An operand scanned
                // Push an operand to the stack
                s += token + " ";
            }
        }

        // Phase 2: process all the remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            s += operatorStack.pop() + " ";
        }

        return s;
    }
}
