package n01_data_structures;

import utils01.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class LC1586BinarySearchTreeIteratorII
{
    ArrayList<TreeNode> inorder;
    int posn;

    public LC1586BinarySearchTreeIteratorII(TreeNode root)
    {
        posn = -1;
        inorder = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty())
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            inorder.add(root);
            root = root.right;
        }
    }

    public int next()
    {
        return inorder.get(++posn).val;
    }

    public boolean hasNext()
    {
        return inorder.size() > posn + 1;
    }

    public boolean hasPrev()
    {
        return posn > 0;
    }

    public int prev()
    {
        return inorder.get(--posn).val;
    }
}
