package n01_data_structures;

import utils.TreeNode;

public class LC0235LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)     {
        if ((p.val <= root.val && root.val <= q.val) || (q.val <= root.val && root.val <= p.val)) return root;

        if (p.val < root.val) return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);

    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q)     {

        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);

        return root;
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q)     {

        while (root != null)
        {
            if (p.val < root.val && q.val < root.val)
            {
                root = root.left;
                continue;
            }
            if (p.val > root.val && q.val > root.val)
            {
                root = root.right;
                continue;
            }
            break;
        }


        return root;
    }

}
