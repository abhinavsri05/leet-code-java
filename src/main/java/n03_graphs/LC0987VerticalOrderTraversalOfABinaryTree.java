package n03_graphs;

import utils01.TreeNode;

import java.util.*;

public class LC0987VerticalOrderTraversalOfABinaryTree
{
    private class Node
    {
        TreeNode node;
        int verticalLevel;
        Node(TreeNode node, int verticalLevel)
        {
            this.node = node;
            this.verticalLevel = verticalLevel;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;
        int minCol = 0;
        int maxCol = 0;
        HashMap<Integer, PriorityQueue<int[]>> map = new HashMap<>();
        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(root, 0));
        int sz = q.size();
        int i;
        int depth = 0;
        while (sz > 0)
        {
            for (i = 0; i < sz; i++)
            {
                Node n = q.poll();
                minCol = Math.min(minCol, n.verticalLevel);
                maxCol = Math.max(maxCol, n.verticalLevel);
                PriorityQueue<int[]> pq = map.getOrDefault(n.verticalLevel, new PriorityQueue<>(
                        (x, y) ->
                                x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]));
                pq.add(new int[]{n.node.val, depth});
                map.put(n.verticalLevel, pq);
                if (n.node.left != null)
                    q.add(new Node(n.node.left, n.verticalLevel - 1));
                if (n.node.right != null)
                    q.add(new Node(n.node.right, n.verticalLevel + 1));
            }
            sz = q.size();
            depth ++;
        }

        for (i = minCol; i <= maxCol; i++)
        {
            List<Integer> list = new ArrayList<>();
            PriorityQueue<int[]> pq = map.get(i);
            while (!pq.isEmpty())
            {
                list.add(pq.remove()[0]);
            }
            output.add(list);
        }

        return output;
    }
}
