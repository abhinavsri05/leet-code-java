package n03_graphs;

import utils01.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC0637AverageOfLevelsInBinaryTree
{
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> output = new ArrayList<>();
        if (root == null) return output;
        Deque<TreeNode> q = new ArrayDeque<>();

        q.add(root);
        int sz = q.size();
        int i;
        double sum;

        while (sz > 0)
        {
            sum = 0.0d;
            for (i = 0; i < sz; i++)
            {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            output.add(sum / sz);
            sz = q.size();
        }

        return output;

    }
}
