package n01_data_structures;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC0144BinaryTreePreOrderTraversal {

    // Recursive approach
    private void traverse(TreeNode node, List<Integer> output)
    {
        if (node == null) return;
        output.add(node.val);
        traverse(node.left, output);
        traverse(node.right, output);

    }

    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> output = new LinkedList<>();

        traverse(root, output);

        return output;
    }

    // Iterative approach
    public List<Integer> preorderTraversal2(TreeNode root)
    {
        List<Integer> output = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node;

        if (root!= null) stack.push(root);

        while (!stack.isEmpty())
        {
            node = stack.pop();
            output.add(node.val);
            if (node.right != null) stack.push(node.right);  // Right is first since stack is used and the left node will be available before right on pop
            if (node.left != null) stack.push(node.left);

        }

        return output;
    }

}
