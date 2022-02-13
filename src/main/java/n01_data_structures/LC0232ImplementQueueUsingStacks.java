package n01_data_structures;

import java.util.Deque;
import java.util.LinkedList;

public class LC0232ImplementQueueUsingStacks {
    // First Attempt
//    private Deque<Integer> stack1;
//    private Deque<Integer> stack2;
//
//
//    public LC0232ImplementQueueUsingStacks() {
//        stack1 = new LinkedList<>();
//        stack2 = new LinkedList<>();
//    }
//
//    public void push(int x) {
//        stack1.push(x);
//
//    }
//
//    public int pop() {
//        if (stack2.size() != 0) return stack2.pop();
//        moveElementsFromFirstStackToSecond();
//        return stack2.pop();
//
//
//    }
//
//    public int peek() {
//        if (stack2.size() != 0) return stack2.peek();
//        moveElementsFromFirstStackToSecond();
//        return stack2.peek();
//
//    }
//
//    public boolean empty() {
//        return stack1.size() == 0 && stack2.size() == 0;
//
//    }
//
//    private void moveElementsFromFirstStackToSecond()
//    {
//        while (stack1.size() > 0)
//        {
//            stack2.push(stack1.pop());
//        }
//    }

    // Second Attempt - keeping track of topElement
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    private int topElement;

    public LC0232ImplementQueueUsingStacks() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        // System.out.println("Push:" + x);
        if (empty()) topElement = x;
        stack1.push(x);
    }

    public int pop() {
        if (stack2.size() != 0)
        {
            int ret = stack2.pop();
            if (stack2.size() > 0)
                topElement = stack2.peek();
            else
            {
                moveElementsFromFirstStackToSecond();
                if (stack2.size() > 0) topElement = stack2.peek();
            }

            return ret;
        }
        moveElementsFromFirstStackToSecond();
        int ret = stack2.pop();
        if (stack2.size() > 0) topElement = stack2.peek();
        return ret;


    }

    public int peek() {
        // System.out.println("Peek:" + topElement);
        return topElement;

    }

    public boolean empty() {
        return stack1.size() == 0 && stack2.size() == 0;

    }

    private void moveElementsFromFirstStackToSecond()
    {
        while (stack1.size() > 0)
        {
            stack2.push(stack1.pop());
        }
    }
}
