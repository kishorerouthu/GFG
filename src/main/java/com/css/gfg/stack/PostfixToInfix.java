package com.css.gfg.stack;

import java.util.Stack;

/**
 * Problem Statement
 * Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
 * Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
 * Postfix notation, also known as reverse Polish notation, is a syntax for mathematical expressions in which the mathematical operator is always placed after the operands. Though postfix expressions are easily and efficiently evaluated by computers, they can be difficult for humans to read. Complex expressions using standard parenthesized infix notation are often more readable than the corresponding postfix expressions. Consequently, we would sometimes like to allow end users to work with infix notation and then convert it to postfix notation for computer processing. Sometimes, moreover, expressions are stored or generated in postfix, and we would like to convert them to infix for the purpose of reading and editing
 *
 * Examples:
 * Input : abc++
 * Output : (a + (b + c))
 *
 * Input  : ab*c+
 * Output : ((a*b)+c)
 */
public class PostfixToInfix {
    public static void main(String[] args) {
        String postfix = "ab*c+";
        String infix = postfixToInfix(postfix);
        System.out.println(infix);
    }

    public static String postfixToInfix(String s) {
        char chars[] = s.toCharArray();
        Stack<String> stack = new Stack();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                if (stack.isEmpty()) {
                    return "Invalid Expression";
                }
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                stack.push("(" + operand1 + c + operand2 + ")");
            }
        }

        if (stack.isEmpty()) {
            return "Invalid Expression";
        }
        return stack.pop();
    }
}
