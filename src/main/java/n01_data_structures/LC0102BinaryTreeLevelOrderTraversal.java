package n01_data_structures;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC0102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> output = new LinkedList<>();

        if (root == null) return output;

        List<TreeNode> prev = new LinkedList<>();
        List<TreeNode> curr;

        List<Integer> vals;
        prev.add(root);

        while (!prev.isEmpty())
        {
            curr = new LinkedList<>();
            vals = new LinkedList<>();
            for (TreeNode n: prev)
            {
                if (n.left != null) curr.add(n.left);
                if (n.right != null) curr.add(n.right);
                vals.add(n.val);
            }
            output.add(vals);
            prev = curr;
        }

        return output;
    }
}
