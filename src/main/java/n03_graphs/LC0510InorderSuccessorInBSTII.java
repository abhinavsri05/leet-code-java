package n03_graphs;

import utils04.Node;

public class LC0510InorderSuccessorInBSTII
{
    public Node inorderSuccessor(Node node) {
        // Successor will always be in right of node (original). If right child of original node is null then no inorder successor

        if (node.right == null)
        {
            if (node.parent != null && node == node.parent.left)
                return node.parent; // if node is the left child
            else
            {
                while (node.parent != null && node == node.parent.right)
                {
                    node = node.parent;
                }

                return node.parent;
            }
        }
        node = node.right;
        while (node != null && node.left != null)
        {
            node = node.left;
        }

        return node;
    }
}
