package n03_graphs;

public class P0617MergeTwoBinaryTree {

    private class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    // Without using ternary operator
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
//    {
//        if (root1 == null && root2 == null)
//            return null;
//
//        TreeNode childLt1, childRt1, childLt2, childRt2;
//
//        int val = 0;
//
//
//        if (root1 != null)
//        {
//            childLt1 = root1.left;
//            childRt1 = root1.right;
//            val += root1.val;
//        }
//        else
//        {
//            childLt1 = null;
//            childRt1 = null;
//        }
//
//        if (root2 != null)
//        {
//            childLt2 = root2.left;
//            childRt2 = root2.right;
//            val += root2.val;
//        }
//        else
//        {
//            childLt2 = null;;
//            childRt2 = null;
//        }
//
//        TreeNode left = mergeTrees(childLt1, childLt2);
//        TreeNode right = mergeTrees(childRt1, childRt2);
//
//        return new TreeNode(val, left, right);
//
//    }

    // Using ternary operator to remove usage of child objects.

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
    {
        if (root1 == null && root2 == null)
            return null;

        return new TreeNode(
                (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val),
                mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left),
                mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right)
        );

    }
}
