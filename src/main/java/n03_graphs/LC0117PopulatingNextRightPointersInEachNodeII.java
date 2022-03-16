package n03_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LC0117PopulatingNextRightPointersInEachNodeII {
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
    // Attempt 1 (Level order traversal)
    public Node connect(Node root) {
        if (root == null) return null;
        Node ret = root;
        Node node, prevPtr;
        LinkedList<Node> curr, next;

        curr = new LinkedList<Node>();
        curr.add(root);


        while (!curr.isEmpty())
        {
            prevPtr = null;
            next = new LinkedList<Node>();
            while (!curr.isEmpty())
            {
                node = curr.remove();
                if (prevPtr != null) prevPtr.next = node;

                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);

                prevPtr = node;
            }
            curr = next;
        }

        return ret;

    }

    // Attempt 2: Using single queue
    public Node connect2(Node root) {
        if (root == null) return null;
        Node ret = root;
        Node node, prevPtr;
        Queue<Node> q = new LinkedList<Node>();
        int size = 0;

        q.add(root);


        while (!q.isEmpty())
        {
            prevPtr = null;
            size = q.size();
            while (size > 0)
            {
                node = q.remove();
                if (prevPtr != null) prevPtr.next = node;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

                prevPtr = node;
                size--;
            }
        }

        return ret;
    }


}
