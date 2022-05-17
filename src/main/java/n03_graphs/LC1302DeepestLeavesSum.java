package n03_graphs;

import javafx.util.Pair;
import utils01.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LC1302DeepestLeavesSum
{
    // BFS
    public int deepestLeavesSum1(TreeNode root)
    {
        if (root == null) return 0;
        int sum = 0;
        int sz, i;
        TreeNode node;
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty())
        {
            sum = 0;
            sz = q.size();
            for (i = 0; i < sz; i++)
            {
                node = q.remove();
                sum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }

        return sum;
    }

    // DFS - Iterative
    public int deepestLeavesSum2(TreeNode root)
    {
        if (root == null) return 0;
        int sum = 0;
        int maxHeight = 0;
        int ht, val;
        TreeNode n;
        Pair<TreeNode, Integer> node;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty())
        {
            node = stack.pop();
            ht = node.getValue();
            n = node.getKey();
            if (n.left == null && n.right == null)
            {
                if (ht == maxHeight)
                {
                    sum += n.val;
                }
                if (ht > maxHeight)
                {
                    maxHeight = ht;
                    sum = n.val;
                }
            }
            if (n.left != null) stack.push(new Pair(n.left, ht + 1));
            if (n.right != null) stack.push(new Pair(n.right, ht + 1));

        }

        return sum;
    }

    // DFS - Recursive - best solution (fastest)
    private int maxHeight = 0;
    private int sum = 0;
    private void dfs(TreeNode node, int height)
    {
        boolean leaf = true;
        if (node.left != null)
        {
            leaf = false;
            dfs(node.left, height + 1);
        }
        if (node.right != null)
        {
            leaf = false;
            dfs(node.right, height + 1);
        }
        if (leaf)
        {
            if (maxHeight == height)
            {
                sum += node.val;
            }
            else
            {
                if (maxHeight < height)
                {
                    maxHeight = height;
                    sum = node.val;
                }
            }
        }
    }
    public int deepestLeavesSum(TreeNode root)
    {
        if (root == null) return 0;

        dfs(root, 1);

        return sum;
    }
}
