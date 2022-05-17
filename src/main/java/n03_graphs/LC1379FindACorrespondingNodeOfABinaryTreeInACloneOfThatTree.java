package n03_graphs;

import javafx.util.Pair;
import utils01.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree
{
    // Attempt 1
    public final TreeNode getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if (original == null) return null;

        Deque<TreeNode> queue1 = new ArrayDeque<>();
        Deque<TreeNode> queue2 = new ArrayDeque<>();

        TreeNode or, cl;

        queue1.add(original);
        queue2.add(cloned);

        while (!queue1.isEmpty())
        {
            or = queue1.remove();
            cl = queue2.remove();

            if (target.val == cl.val) return cl; // change to if (or == target) return cl; for follow up question

            if (or.left != null)
            {
                queue1.add(or.left);
                queue2.add(cl.left);
            }
            if (or.right != null)
            {
                queue1.add(or.right);
                queue2.add(cl.right);
            }
        }

        return null;

    }

    // Attempt 2
    private String getRoute(TreeNode node, TreeNode target)
    {
        // 0:Left , 1:Right
        Deque<Pair<TreeNode, String>> q = new ArrayDeque<>();

        q.add(new Pair(node, ""));

        Pair<TreeNode, String> n;

        while (!q.isEmpty())
        {
            n = q.remove();

            if (n.getKey().left != null)
            {
                if (n.getKey().left == target)
                    return n.getValue() + "0";
                q.add(new Pair(n.getKey().left, n.getValue() + "0"));
            }
            if (n.getKey().right != null)
            {
                if (n.getKey().right == target)
                    return n.getValue() + "1";
                q.add(new Pair(n.getKey().right, n.getValue() + "1"));
            }

        }
        return "";
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if (original == null) return null;
        if (original == target) return cloned;

        TreeNode clone = cloned;

        String route = getRoute(original, target);

        for (int i = 0; i < route.length(); i++)
        {
            if (route.charAt(i) == '0')
                clone = clone.left;
            else
                clone = clone.right;
        }

        return clone;

    }
}
