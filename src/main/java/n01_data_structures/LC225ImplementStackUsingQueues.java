package n01_data_structures;

import java.util.LinkedList;
import java.util.Queue;

public class LC225ImplementStackUsingQueues
{
    final private Queue<Integer> queue;

    public LC225ImplementStackUsingQueues()
    {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        int s = queue.size();
        // Add s items in reverse order to the same queue
        for (int i = 1; i < s; i++)
            queue.add(queue.remove());
    }

    public int pop()
    {
        return queue.remove();
    }

    public int top()
    {
        return queue.peek();
    }

    public boolean empty()
    {
        return queue.isEmpty();
    }
}
