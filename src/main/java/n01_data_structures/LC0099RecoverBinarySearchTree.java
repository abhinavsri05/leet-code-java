package n01_data_structures;

import utils01.TreeNode;

import java.util.LinkedList;

public class LC0099RecoverBinarySearchTree
{
    public void recoverTree(TreeNode root)
    {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        TreeNode p = null, c = null;

        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                // System.out.println("Push: " + root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // System.out.println(root.val);
            if (prev != null && prev.val > root.val)
            {// c and p may not be adjacent in inorder traversal
                c = root;
                if (p == null) p = prev;
                else break;
            }
            prev = root;
            root = root.right;

        }
        int temp = p.val;
        p.val = c.val;
        c.val = temp;
    }
}
