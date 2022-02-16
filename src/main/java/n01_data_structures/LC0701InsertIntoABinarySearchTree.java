package n01_data_structures;

import utils.TreeNode;

public class LC0701InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val)
    {
        if (root == null) return new TreeNode(val);

        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        else
            root.left = insertIntoBST(root.left, val);

        return root;
    }
}
