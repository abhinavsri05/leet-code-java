package n03_graphs;

import utils01.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC0314BinaryTreeVerticalOrderTraversal
{
    /* DFS does not work since it first traverses all left child then right. so right second row will be traversed after leaves of left, which is incorrect.

    private void helper(TreeNode node, HashMap<Integer, List<Integer>> nodesByOrder, int parent, int[] levels)
    {
        if (node == null) return;

        levels[0] = Math.min(levels[0], parent);
        levels[1] = Math.max(levels[1], parent);

        List<Integer> nodes = nodesByOrder.getOrDefault(parent, new ArrayList<>());
        nodes.add(node.val);
        nodesByOrder.put(parent, nodes);

        helper(node.left, nodesByOrder, parent - 1, levels);
        helper(node.right, nodesByOrder, parent + 1, levels);
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        HashMap<Integer, List<Integer>> nodesByOrder = new HashMap<>();
        int[] extremes = new int[2];
        extremes[0] = 0;  // min
        extremes[1] = 0;  // max

        helper(root, nodesByOrder, 0, extremes);

        for (int i = extremes[0]; i <= extremes[1]; i++)
        {
            output.add(nodesByOrder.get(i));
        }
        return output;

    }
    */

    /*
    Using BFS and HashMap

    private class Entry
    {
        TreeNode node;
        int level;

        Entry(TreeNode node, int level)
        {
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;

        HashMap<Integer, List<Integer>> nodesByOrder = new HashMap<>();
        int[] extremes = new int[2];
        extremes[0] = 0;  // min
        extremes[1] = 0;  // max

        ArrayDeque<Entry> q = new ArrayDeque<>();
        q.add(new Entry(root, 0));


        while (!q.isEmpty())
        {
            Entry top = q.remove();
            List<Integer> nodes = nodesByOrder.getOrDefault(top.level, new ArrayList<>());
            nodes.add(top.node.val);
            nodesByOrder.put(top.level, nodes);
            extremes[0] = Math.min(extremes[0], top.level);
            extremes[1] = Math.max(extremes[1], top.level);
            if (top.node.left != null)
            {
                q.add(new Entry(top.node.left, top.level - 1));
            }
            if (top.node.right != null)
            {
                q.add(new Entry(top.node.right, top.level + 1));
            }
        }

        for (int i = extremes[0]; i <= extremes[1]; i++)
        {
            output.add(nodesByOrder.get(i));
        }
        return output;
    }
    */

    // Using Array and BFS
    private class Entry
    {
        TreeNode node;
        int level;

        Entry(TreeNode node, int level)
        {
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;

        List<Integer>[] nodesByOrder = new List[201]; // -100 goes to 0, 100 to 200

        ArrayDeque<Entry> q = new ArrayDeque<>();
        q.add(new Entry(root, 0));


        while (!q.isEmpty())
        {
            Entry top = q.remove();
            if (nodesByOrder[top.level + 100] == null)
            {
                nodesByOrder[top.level + 100] = new ArrayList<>();
            }
            nodesByOrder[top.level + 100].add(top.node.val);

            if (top.node.left != null)
            {
                q.add(new Entry(top.node.left, top.level - 1));
            }
            if (top.node.right != null)
            {
                q.add(new Entry(top.node.right, top.level + 1));
            }
        }

        for (int i = 0; i <= 200; i++)
        {
            if (nodesByOrder[i] != null )
                output.add(nodesByOrder[i]);
        }
        return output;
    }
}
