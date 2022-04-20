package n01_data_structures;

import utils01.TreeNode;

import java.util.LinkedList;

public class LC0230KthSmallestElementInABST
{
    public int kthSmallest(TreeNode root, int k)
    {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
