package n01_data_structures;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC0145BinaryTreePostOrderTraversal {
    private void traverse(TreeNode node, List<Integer> output)
    {
        if (node == null) return;
        traverse(node.left, output);
        traverse(node.right, output);
        output.add(node.val);

    }

    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> output = new LinkedList<>();

        traverse(root, output);

        return output;
    }
}
