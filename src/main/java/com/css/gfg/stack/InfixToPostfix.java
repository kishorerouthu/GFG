package com.css.gfg.stack;

import java.util.Stack;

/**
 * Prerequisite – Stack | Set 1 (Introduction)
 * Infix expression:The expression of the form a op b. When an operator is in-between every pair of operands.
 * Postfix expression:The expression of the form a b op. When an operator is followed for every pair of operands.
 *
 * Why postfix representation of the expression?
 * The compiler scans the expression either from left to right or from right to left.
 *
 * Consider the below expression: a op1 b op2 c op3 d
 * If op1 = +, op2 = *, op3 = +
 *
 * The compiler first scans the expression to evaluate the expression b * c, then again scan the expression to add a to it. The result is then added to d after another scan.
 * The repeated scanning makes it very in-efficient. It is better to convert the expression to postfix(or prefix) form before evaluation.
 *
 * The corresponding expression in postfix form is: abc*+d+.
 * The postfix expressions can be evaluated easily using a stack. We will cover postfix expression evaluation in a separate post.
 */
public class InfixToPostfix {

    public static void main(String[] args) {
        String infix = "a+b*c+d";  //abc*+d+
        infix = "a+b*(c^d-e)^(f+g*h)-i"; //abcd^e-fgh*+^*+i-
        infix = "((a+b)*c-d)*e"; //ab+c*d-e*
        infix = "a*(b+c)"; //abc+*
        String postfix = toPostfix(infix);
        System.out.println(postfix);
    }

    private static String toPostfix(String s) {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        int size = chars.length;
        for (int i=0; i<size; i++) {
            char c = chars[i];
            if(Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if(c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek()!= '(') {
                    result.append(stack.pop());
                }

                if (!stack.isEmpty() && stack.peek() !='(')
                    return "Invalid Expression";
                else
                    stack.pop();
            }  else {
                while (!stack.isEmpty() && (precedence(c) <= precedence(stack.peek()))) {
                    if (stack.peek() == '(')
                        return "Invalid Expression";
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Result";
            result.append(stack.pop());
        }
        return result.toString();
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
