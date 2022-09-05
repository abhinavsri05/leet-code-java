package n03_graphs;

import utils02.Node;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class LC0429NaryTreeLevelOrderTraversal
{
    public List<List<Integer>> levelOrder(Node root)
    {
        List<List<Integer>> output = new LinkedList<>();
        if (root == null) return output;

        ArrayDeque<Node> q = new ArrayDeque<>();

        q.add(root);
        int sz = 1;
        int i;

        while (sz > 0)
        {
            List<Integer> l = new LinkedList<>();
            for (i = 0; i < sz; i++)
            {
                Node n = q.poll();
                l.add(n.val);
                for (Node child: n.children)
                    q.add(child);
            }
            sz = q.size();
            output.add(l);
        }
        return output;
    }
}
