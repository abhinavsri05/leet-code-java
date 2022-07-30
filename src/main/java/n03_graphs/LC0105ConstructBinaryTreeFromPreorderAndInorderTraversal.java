package n03_graphs;

import utils01.TreeNode;

import java.util.HashMap;

public class LC0105ConstructBinaryTreeFromPreorderAndInorderTraversal
{
    private int preOrEl;
    private TreeNode helper(int[] preorder, HashMap<Integer, Integer> inorderPosn, int start, int end)
    {
        if (start > end) return null;
        TreeNode node = new TreeNode(preorder[preOrEl]);
        preOrEl++;
        if (start == end) return node;

        node.left =  helper(preorder, inorderPosn, start, inorderPosn.get(node.val) - 1);
        node.right =  helper(preorder, inorderPosn, inorderPosn.get(node.val) + 1, end);


        return node;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        int n = preorder.length;
        preOrEl = 0;

        HashMap<Integer, Integer> inorderPosn = new HashMap<>();

        for (int i = 0; i < n; i++)
            inorderPosn.put(inorder[i], i);

        TreeNode root = helper(preorder, inorderPosn, 0, n - 1);

        return root;

    }
}
