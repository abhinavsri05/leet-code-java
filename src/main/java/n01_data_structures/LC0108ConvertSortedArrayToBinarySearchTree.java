package n01_data_structures;

import utils01.TreeNode;

public class LC0108ConvertSortedArrayToBinarySearchTree
{
    private TreeNode constructTree(int[] nums, int start, int end)
    {
        if (start == end) return new TreeNode(nums[start]);
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructTree(nums, start, mid - 1);
        node.right = constructTree(nums, mid + 1, end);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums)
    {
        return constructTree(nums, 0, nums.length - 1);
    }
}
