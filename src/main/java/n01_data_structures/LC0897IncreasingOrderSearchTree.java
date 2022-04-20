package n01_data_structures;

import utils01.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC0897IncreasingOrderSearchTree
{
    private void inOrder(TreeNode root, List<TreeNode> inorder)
    {
        if (root == null) return;
        inOrder(root.left, inorder);
        inorder.add(root);
        inOrder(root.right, inorder);
    }

    public TreeNode increasingBST(TreeNode root)
    {
        List<TreeNode> inorder = new ArrayList<>();
        inOrder(root, inorder);
        TreeNode node = new TreeNode();
        TreeNode prev = node;
        // Make sure the last node has both left and right set to null
        for (TreeNode n: inorder)
        {
            n.left = null;
            n.right = null;
            prev.right = n;
            prev = n;
        }
        return node.right;
    }
}
