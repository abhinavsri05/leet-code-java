package n01_data_structures;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC0094BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node;

        node = root;

        while (node != null || !stack.isEmpty())
        {
            while (node != null)
            {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            output.add(node.val);
            node = node.right;
        }

        return output;
    }
}
