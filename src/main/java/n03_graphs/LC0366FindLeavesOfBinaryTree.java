package n03_graphs;

import utils01.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC0366FindLeavesOfBinaryTree
{
    private boolean dfs(TreeNode node, List<Integer> leaf)
    {
        if (node.left == null && node.right == null)
        {
            leaf.add(node.val);
            return true; // This is leaf, parent can set the pointer to null
        }

        boolean ret;

        if (node.left != null)
        {
            ret = dfs(node.left, leaf);
            if(ret) node.left = null;
        }
        if (node.right != null)
        {
            ret = dfs(node.right, leaf);
            if (ret) node.right = null;
        }
        return false; // node is not a leaf
    }
    public List<List<Integer>> findLeaves(TreeNode root)
    {
        List<List<Integer>> output = new LinkedList<>();
        if (root == null) return output;

        boolean ret = false;
        while (!ret)
        {
            List<Integer> leaf = new LinkedList<>();
            ret = dfs(root, leaf);
            output.add(leaf);
        }
        return output;
    }
}
