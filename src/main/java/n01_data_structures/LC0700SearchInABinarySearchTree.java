package n01_data_structures;

import utils.TreeNode;

public class LC0700SearchInABinarySearchTree
{
    // Attempt 1
    // Does not actually use BST format.
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);

        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
    // Attempt 2
    // Trims down BST in half at each step
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        return  val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);

    }

    // Attempt 3
    // Iterative
    public TreeNode searchBST3(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        return null;

    }

}
