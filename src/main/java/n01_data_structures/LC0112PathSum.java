package n01_data_structures;

import utils01.TreeNode;

public class LC0112PathSum {

    //First Attempt
    public boolean hasPathSum(TreeNode root, int targetSum)
    {
        if (root == null) return false;

        boolean leftResult, rightResult;

        if (root.left != null)
            leftResult = hasPathSum(root.left, targetSum - root.val);
        else
        {
            if (targetSum == root.val && root.right == null)
                leftResult = true;
            else
                leftResult = false;
        }

        if (root.right != null)
            rightResult = hasPathSum(root.right, targetSum - root.val);
        else
        {
            if (targetSum == root.val && root.left == null)
                rightResult = true;
            else
                rightResult = false;
        }

        return leftResult || rightResult;
    }

    // Second attempt - LC

    public boolean hasPathSum2(TreeNode root, int targetSum)
    {
        if (root == null) return false;

        if (root.left == null && root.right == null)
            return root.val == targetSum;

        return hasPathSum2(root.left, targetSum - root.val) ||
                hasPathSum2(root.right, targetSum - root.val);
    }

}
