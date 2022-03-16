package n01_data_structures;

import utils01.TreeNode;

public class LC0572SubtreeOfAnotherTree {

    // Note that the same node value can occur multiple times and first one may not be the sub tree.

    private boolean validateSubTree(TreeNode root, TreeNode subRoot)
    {
        // if (root == null && subRoot == null) return true;
        // if (root == null || subRoot == null) return false;

        // The above two line are also the same base conditions as the one's below

        if (root == null)
        {
            if (subRoot == null)
                return true;
            else
                return false;
        }
        if(subRoot == null) return false;

        return root.val == subRoot.val && validateSubTree(root.left, subRoot.left) && validateSubTree(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if (root == null && subRoot == null) return true;
        // if (root == null || subRoot == null) return false;

        // The above two line are also the same base conditions as the one's below

        if (root == null)
        {
            if (subRoot == null)
                return true;
            else
                return false;
        }
        if(subRoot == null) return false;

        if (validateSubTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);


    }
}
