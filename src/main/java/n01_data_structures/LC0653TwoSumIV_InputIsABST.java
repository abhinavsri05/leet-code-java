package n01_data_structures;

import utils.TreeNode;

import java.util.HashSet;

public class LC0653TwoSumIV_InputIsABST {
    private HashSet<Integer> seen = new HashSet<>();

    public boolean findTarget(TreeNode root, int k)
    {
        if (root == null) return false;

        if (seen.contains(k - root.val)) return true;
        seen.add(root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);

    }
}
