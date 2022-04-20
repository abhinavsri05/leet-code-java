package leet_code_contests.weekly.wc289_20220416;

import java.util.HashMap;
import java.util.LinkedList;

public class LC2246LongestPathWithDifferentAdjacentCharacters {
    // Attempt during contest-
    class TreeNode
    {
        char val;
        LinkedList<TreeNode> child;
        TreeNode(char val)
        {
            this.val = val;
            this.child = new LinkedList<TreeNode>();
        }
        void addChild(TreeNode c)
        {
            this.child.add(c);
        }

    }

    private TreeNode convertToLL(int[] parent, String s)
    {
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        int i;

        // Create Nodes
        for (i = 0; i < parent.length; i++)
        {
            nodes.put(i, new TreeNode(s.charAt(i)));
        }

        // Create Tree (not given if parent occur before childresn in array)
        for (i = 1; i < parent.length; i++)
        {
            nodes.get(parent[i]).addChild(nodes.get(i));
        }

        return nodes.get(0);
    }

    int maxLength = 0;

    void findPath(TreeNode node, int l, char prev)
    {
        if (node.val == prev)
            l = 0;
        else
            l++;
        maxLength = Math.max(maxLength, l);
        char prevChild = ' ';

        for (TreeNode c: node.child)
        {
            if (c.val != node.val && prevChild != node.val)
                findPath(c, maxLength, node.val);
            else
                findPath(c, l, node.val);
        }
    }

    public int longestPath(int[] parent, String s)
    {
        TreeNode root = convertToLL(parent, s);

        findPath(root, 0, ' ');
        return maxLength;

    }
}
