package com.css.gfg.stack;

import java.util.Stack;

/**
 * Prefix to Postfix Conversion
 * Prefix : An expression is called the prefix expression if the operator appears in the expression before the operands. Simply of the form (operator operand1 operand2).
 * Example : *+AB-CD (Infix : (A+B) * (C-D) )
 *
 * Postfix: An expression is called the postfix expression if the operator appears in the expression after the operands. Simply of the form (operand1 operand2 operator).
 * Example : AB+CD-* (Infix : (A+B * (C-D) )
 *
 * Given a Prefix expression, convert it into a Postfix expression.
 * Conversion of Prefix expression directly to Postfix without going through the process of converting them first to Infix and then to Postfix is much better in terms of computation and better understanding the expression (Computers evaluate using Postfix expression).
 *
 * Examples:
 * Input :  Prefix :  *+AB-CD
 * Output : Postfix : AB+CD-*
 * Explanation : Prefix to Infix :  (A+B) * (C-D)
 *               Infix to Postfix :  AB+CD-*
 *
 * Input :  Prefix :  *-A/BC-/AKL
 * Output : Postfix : ABC/-AK/L-*
 * Explanation : Prefix to Infix :  A-(B/C)*(A/K)-L
 *               Infix to Postfix : ABC/-AK/L-*
 */
public class PrefixToPostfix {

    public static void main(String[] args) {
        String prefix = "*+AB-CD";
        prefix = "*-A/BC-/AKL";
        final String result = prefixToPostfix(prefix);
        System.out.println(result);
    }

    private static String prefixToPostfix(String prefix) {
        char chars[] = prefix.toCharArray();
        Stack<String> stack = new Stack<String>();
        for (int i=chars.length-1; i>=0; i--) {
            char c = chars[i];
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                if (stack.isEmpty()) {
                    return "Invalid Expression";
                }
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push(operand1 + operand2 + c);
            }
        }

        if (stack.isEmpty()) {
            return "Invalid Expression";
        }
        return stack.pop();
    }

}
