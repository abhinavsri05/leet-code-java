package n03_graphs;

import utils01.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC0199BinaryTreeRightSideView
{
    // The following looks correct but does not work if down somewhere the child of left node is the rightmost like [1, 2, 3, 4]
    /*
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> output = new LinkedList<>();

        while (root != null)
        {
            output.add(root.val);
            if (root.right != null)
                root = root.right;
            else
                root = root.left;
        }

        return output;
    }
    */

    // BFS approach using one Deque
    public List<Integer> rightSideView1(TreeNode root)
    {
        List<Integer> output = new LinkedList<>();

        if (root == null) return output;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int n;

        while (queue.size() > 0)
        {
            n = queue.size();
            output.add(queue.getLast().val);
            while (n > 0)
            {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                n--;
            }
        }
        return output;
    }

    // Using DFS
    // Note that the key is to read right child and then left, but we also need to track the level since we do not add left child if a node to the right of it in level order exists.

    private void dfs(TreeNode node, int depth, List<Integer> output)
    {
        if (node == null) return;
        if (output.size() == depth)
            output.add(node.val);

        dfs(node.right, depth + 1, output);
        dfs(node.left, depth + 1, output);
    }

    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> output = new LinkedList<>();

        if (root == null) return output;

        dfs(root, 0, output);

        return output;
    }
}
