package n01_data_structures;

import utils01.TreeNode;

public class LC0104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));


    }
}
