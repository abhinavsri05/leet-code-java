package n01_data_structures;

import utils01.TreeNode;

public class LC0669TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high)
    {
        if (root == null) return null;
        // Bounds entirely in right
        if (root.val < low) return trimBST(root.right, low, high);

        // Bounds entirely in left
        if (root.val > high) return trimBST(root.left, low, high);

        // root node within the nodes
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
