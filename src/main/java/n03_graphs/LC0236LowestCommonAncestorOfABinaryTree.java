package n03_graphs;

import utils01.TreeNode;

public class LC0236LowestCommonAncestorOfABinaryTree
{
    /*
    The solution will only try to find one of the two nodes in a subtree. It returns as soon as one is found. In example 2 ([3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4) when it finds 5, it will return thereby never reaching 4. Since it is known that both the nodes p and q exist in the tree this statement works.
    If 4 is a descendent of 5 then 5 will be the answer else we have to look for 4 elsewhere.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null) return null;
        if (root == p || root == q) return root;

        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);

        if (leftTree != null && rightTree != null)
            return root;
        if (leftTree == null && rightTree == null)
            return null;
        if (leftTree != null)
            return leftTree;
        else
            return rightTree;
    }
}
