package n01_data_structures;

import java.util.Deque;
import java.util.LinkedList;

public class LC0682BaseballGame
{
    public int calPoints(String[] ops)
    {
        // Cannot use an array of fixed length since do not know how many values will need to be removed
        Deque<Integer> stack = new LinkedList<>();
        int top;
        int curr;
        int sum = 0;

        for (String op : ops)
        {
            switch (op)
            {
                case "+":
                    top  = stack.pop();
                    curr = top + stack.peek();
                    stack.push(top);
                    stack.push(curr);
                    sum += stack.peek();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    sum += stack.peek();
                    break;
                case "C":
                    sum -= stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    sum += stack.peek();
                    break;
            }
        }
        return sum;
    }
}
