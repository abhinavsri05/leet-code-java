package n01_data_structures;

import java.util.Stack;

public class LC0946ValidateStackSequences
{
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;

        if (popped.length != n) return false;
        if (n == 0) return true;

        Stack<Integer> stack = new Stack<Integer>();

        int push = 0;
        int pop = 0;

        while(push < n || pop < n)
        {
            if (!stack.isEmpty() && stack.peek() == popped[pop])
            {
                stack.pop();
                pop++;
            }
            else
            {
                if (push < n) stack.push(pushed[push++]);
                else return false;
            }
        }

        return true;
    }
}
