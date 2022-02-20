package n04_greedy_random;

import java.util.LinkedList;

public class LC0402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char digit: num.toCharArray())
        {
            while (stack.size() > 0 && k > 0 && digit < stack.peekLast())
            {
                stack.removeLast();
                k--;
            }

            stack.addLast(digit);
        }

        for (int i = 0; i < k; i++)
        {
            stack.removeLast();
        }

        StringBuilder output = new StringBuilder();
        boolean firstDigit = true;
        for (char ch: stack)
        {
            if (firstDigit && ch == '0') continue;
            firstDigit = false;
            output.append(ch);
        }

        if (output.length() == 0) return "0";

        return output.toString();
    }

}
