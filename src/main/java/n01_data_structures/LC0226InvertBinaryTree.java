package n01_data_structures;
import utils.TreeNode;

public class LC0226InvertBinaryTree {
    private void helper(TreeNode root)
    {
        if (root == null) return;

        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
    }

    public TreeNode invertTree(TreeNode root) {

        helper(root);
        return root;

    }

}
