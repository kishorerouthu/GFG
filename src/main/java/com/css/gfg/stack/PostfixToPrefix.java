package com.css.gfg.stack;

import java.util.Stack;

/**
 * Problem Statement
 * Postfix to Prefix Conversion
 * Postfix: An expression is called the postfix expression if the operator appears in the expression after the operands. Simply of the form (operand1 operand2 operator).
 * Example : AB+CD-* (Infix : (A+B) * (C-D) )
 *
 * Prefix : An expression is called the prefix expression if the operator appears in the expression before the operands. Simply of the form (operator operand1 operand2).
 * Example : *+AB-CD (Infix : (A+B) * (C-D) )
 *
 * Given a Postfix expression, convert it into a Prefix expression.
 * Conversion of Postfix expression directly to Prefix without going through the process of converting them first to Infix and then to Prefix is much better in terms of computation and better understanding the expression (Computers evaluate using Postfix expression).
 *
 * Examples:
 *
 * Input :  Postfix : AB+CD-*
 * Output : Prefix :  *+AB-CD
 * Explanation : Postfix to Infix : (A+B) * (C-D)
 *               Infix to Prefix :  *+AB-CD
 *
 * Input :  Postfix : ABC/-AK/L-*
 * Output : Prefix :  *-A/BC-/AKL
 * Explanation : Postfix to Infix : ((A-(B/C))*((A/K)-L))
 *               Infix to Prefix :  *-A/BC-/AKL
 *
 */

public class PostfixToPrefix {
    public static void main(String[] args) {
        String postfix = "AB+CD-*";
        postfix = "ABC/-AK/L-*";
        String result = postfixToPrefix(postfix);
        System.out.println(result);
    }

    private static String postfixToPrefix(String postfix) {
        char chars[] = postfix.toCharArray();
        Stack<String> stack = new Stack();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            }  else {
                if (stack.isEmpty()) {
                    return "Invalid Expression";
                }
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                stack.push(c + operand1 + operand2);
            }
        }

        if (stack.isEmpty()) {
            return "Invalid Expression";
        }
        return stack.pop();
    }
}
