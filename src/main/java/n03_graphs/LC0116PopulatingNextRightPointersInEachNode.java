package n03_graphs;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class LC0116PopulatingNextRightPointersInEachNode
{
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next)
        {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // First attempt - uses iterator and counter. Need a better approach that uses constant space.
    // This approach uses BFS

    public static Node connect(Node root)
    {
        Deque<Node> queue = new LinkedList<>();

        if (root != null) queue.add(root);
        int i;

        Node n;
        Node adj = null;
        while (queue.size() > 0)
        {
            adj = null;
            i = 0;
            Iterator<Node> it = queue.iterator();

            while(it.hasNext())
            {
                Node nd = it.next();
                nd.next = adj;
                adj = nd;
                i++;
            }
            while (i-- > 0)
            {

                n = queue.remove();

                if (n.right != null)
                {
                    queue.add(n.right);
                    queue.add(n.left);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        three.left = six;
        three.right = seven;

        two.left = four;
        two.right = five;

        one.left = two;
        one.right = three;

        Node output = connect(one);

    }
}
