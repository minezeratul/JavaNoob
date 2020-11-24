package Chapter20.q14PostfixNotation;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Evaluation {
     public static void main(String[] args) {
         if (args.length < 1) {
             System.out.println("Usage: java \"Evaluation\" expression");
             System.exit(1);
         }

         String expression = "";
         for (int i = 0; i < args.length; i++) {
             expression += args[i] + " ";
         }

         try {
             System.out.println(evaluateExpression(expression));
         }
         catch (Exception ex) {
             System.out.println("Wrong expression");
         }
     }

    public static int evaluateExpression(String expression) {
        MyStack operandStack = new MyStack();

       StringTokenizer tokens = new java.util.StringTokenizer(expression, " +-/*%", true);

        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken().trim();
            if (token.length() == 0) {
                continue;
            }
            else if (token.charAt(0) == '+' || token.charAt(0) == '-' ||
                    token.charAt(0) == '*' || token.charAt(0) == '/') {
                processAnOperator(token.charAt(0), operandStack);
            }
            else {
                operandStack.push(new Integer(token));
            }
        }

        // Return the result
        return ((Integer)(operandStack.pop())).intValue();
    }


    public static void processAnOperator(char op, MyStack operandStack) {
        if (op == '+') {
            int op1 = ((Integer)(operandStack.pop())).intValue();
            int op2 = ((Integer)(operandStack.pop())).intValue();
            operandStack.push(new Integer(op2 + op1));
        }
        else if (op == '-') {
            int op1 = ((Integer)(operandStack.pop())).intValue();
            int op2 = ((Integer)(operandStack.pop())).intValue();
            operandStack.push(new Integer(op2 - op1));
        }
        else if ((op == '*')) {
            int op1 = ((Integer)(operandStack.pop())).intValue();
            int op2 = ((Integer)(operandStack.pop())).intValue();
            operandStack.push(new Integer(op2 * op1));
        }
        else if (op == '/') {
            int op1 = ((Integer)(operandStack.pop())).intValue();
            int op2 = ((Integer)(operandStack.pop())).intValue();
            operandStack.push(new Integer(op2 / op1));
        }
    }
}

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
