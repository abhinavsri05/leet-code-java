/*
Is 1 * -1 valid input?
 */

package n09_string_manipulation;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC0227BasicCalculatorII {
    public int calculate(String s) {
        Deque<String> stack = new ArrayDeque<>();
        char lastOperator = '\0';
        int operandOne = 0;
        int operandTwo = 0;
        int numStart = 0;
        String operator;
        char ch;

        for (int i = 0; i < s.length(); i++)
        {
            ch = s.charAt(i);

            if (i + 1 == s.length())
            {
                if (lastOperator == '-')
                    stack.push("-" + s.substring(numStart, i + 1));
                else
                    stack.push(s.substring(numStart, i + 1));
            }

            if (ch == '*' || ch == '/' || ch == '+' || ch == '-')
            {
                if (lastOperator == '-')
                    stack.push("-" + s.substring(numStart, i));
                else
                    stack.push(s.substring(numStart, i));

                if (lastOperator == '*' || lastOperator == '/')
                {
                    operandTwo = getNumber(stack.pop());
                    operator = stack.pop();
                    operandOne = getNumber(stack.pop());

                    if (operator.equals("*"))
                        stack.push("" + (operandOne * operandTwo));
                    else
                        stack.push("" + (int)(operandOne / operandTwo));
                }

                lastOperator = ch;
                if (ch == '-') ch = '+';
                stack.push(String.valueOf(ch));
                numStart = i + 1;
            }
        }

        System.out.println(stack.size());

        while (stack.size() > 1)
        {
            operandTwo = getNumber(stack.pop());
            operator = stack.pop();
            operandOne = getNumber(stack.pop());

            if (operator.equals("*"))
                stack.push("" + (operandOne * operandTwo));
            if (operator.equals("/"))
                stack.push("" + (int) (operandOne / operandTwo));
            if (operator.equals("-"))
                stack.push("" + (operandOne - operandTwo));
            if (operator.equals("+"))
                stack.push("" + (operandOne + operandTwo));
        }

        return getNumber(stack.pop());

    }

    private int getNumber(String num)
    {
        int output = 0;
        boolean negative = false;
        for (int j = 0; j < num.length(); j++)
        {
            if (num.charAt(j) == ' ' || num.charAt(j) == '+')
            {
                continue;
            }
            if (num.charAt(j) == '-')
            {
                negative = true;
                continue;
            }
            output = output * 10 + (num.charAt(j) - '0');
        }

        return negative ? -1 * output : output;
    }
}
