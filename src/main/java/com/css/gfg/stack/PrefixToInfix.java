package com.css.gfg.stack;

import java.util.Stack;

/**
 * Convert Prefix expression to Infix expression
 * Examples :
 * Input : -+A*BCD
 * Output : A+B*C-D  (OR)  A+(B*C)-D
 *
 * Input : *+AB-CD
 * Output : (A+B)*(C-D)
 *
 * Input : -*+AB-CDE
 * Output : (A+B)*(C-D) - E
 *
 * Input : *-A/BC-/AKL
 * Output : ((A-(B/C))*((A/K)-L)
 */
public class PrefixToInfix {
    public static void main(String[] args) {
        String prefix = "*+AB-CD";
        prefix = "-*+AB-CDE";
        prefix = "-+A*BCD";
        prefix = "*-A/BC-/AKL";
        String infix = convertToInfix(prefix);
        System.out.println(infix);
    }

    private static String convertToInfix(String expression) {
        char[] chars = expression.toCharArray();
        Stack<String> stack = new Stack();
        for (int i=chars.length-1; i>=0; i--) {
            char c = chars[i];
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                if(stack.isEmpty()) {
                    return "Invalid Expression";
                }
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push("(" + operand1 + c + operand2 + ")");
            }
        }
        if (stack.isEmpty()) {
            return "Invalid Expression";
        }
        return stack.peek();
    }

    /** A utility function to return precedence of a given operator
     Higher returned value means higher precedence
     */
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return 4;
    }

}
