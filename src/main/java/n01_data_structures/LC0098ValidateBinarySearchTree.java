package n01_data_structures;

import utils.TreeNode;

public class LC0098ValidateBinarySearchTree {
    public boolean helper(TreeNode root, Integer ll, Integer hl)
    {
        if (root == null) return true;

        if ((ll != null && root.val <= ll) || (hl != null && root.val >= hl))
            return false;

        return helper(root.left, ll, root.val) && helper(root.right, root.val, hl);

    }

    public boolean isValidBST(TreeNode root) {

        return helper(root, null, null);


    }
}
