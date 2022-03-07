package leet_code_contests.weekly.wc283_20220305;

import utils.TreeNode;

import java.util.HashMap;

public class LC2196CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        HashMap<Integer, Boolean> hasParent = new HashMap<>();
        TreeNode root = null;

        for (int i = 0; i < descriptions.length; i++)
        {
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            boolean isLeft = descriptions[i][2] == 1;

            TreeNode parentNode = nodes.getOrDefault(parent, new TreeNode(parent));
            TreeNode childNode = nodes.getOrDefault(child, new TreeNode(child));

            if (isLeft)
                parentNode.left = childNode;
            else
                parentNode.right = childNode;

            nodes.put(parent, parentNode);
            nodes.put(child, childNode);

            if (!hasParent.containsKey(parent)) hasParent.put(parent, false);
            hasParent.put(child, true);

        }

        for (Integer key: hasParent.keySet())
        {
            if (!hasParent.get(key))
                return nodes.get(key);
        }
        return null;

    }
}
