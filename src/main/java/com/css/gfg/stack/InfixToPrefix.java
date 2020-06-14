package com.css.gfg.stack;

import java.util.Stack;

/**
 * Convert Infix expression to Prefix Expression
 * Input : A * B + C / D
 * Output : + * A B/ C D
 *
 * Input : (A - B/C) * (A/K-L)
 * Output : *-A/BC-/AKL
 *
 * Input : (A + B) * (C - D)
 * Output : *+AB-CD
 *
 */
public class InfixToPrefix {

    public static void main(String[] args) {
        String infix = "A*B+C/D";
        infix = "(A-B/C)*(A/K-L)";
        infix = "(A+B)*(C-D)";
        String prefix = infixToPrefix(infix);
        System.out.println(prefix);
    }

    private static String infixToPrefix(String expression) {
        char[] chars = expression.toCharArray();
        int size = chars.length;
        Stack<Character> result = new Stack();
        Stack<Character> stack = new Stack();
        for (int i=size-1; i>=0; i--) {
            char c = chars[i];
            if (Character.isLetterOrDigit(c)) {
                result.push(c);
            } else if(c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    result.push(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != ')') {
                    return "Invalid Expression";
                } else {
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(c)) {
                    if (stack.peek() == ')') {
                        return "Invalid Expression";
                    }
                    result.push(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == ')') {
                return "Invalid Expression";
            }
            result.push(stack.pop());
        }
        return convertToString(result);
    }

    private static String convertToString(Stack<Character> result) {
        if (result == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }
        return sb.toString();
    }

    /** A utility function to return precedence of a given operator
     Higher returned value means higher precedence
     */
    private static int precedence(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
