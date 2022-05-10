package n01_data_structures;

import utils01.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class LC0341FlattenNestedListIterator implements Iterator<Integer>
{
    // First Attempt - Inorder traversal of n-ary tree
    private List<NestedInteger> nestedList;
    private LinkedList<Integer> queue;
    private int index;
    private int sz;

    public LC0341FlattenNestedListIterator(List<NestedInteger> nestedList)
    {
        this.nestedList = nestedList;
        this.queue = new LinkedList<>();
        iterate(nestedList, queue);
        index = -1;
        sz = queue.size();
    }

    private void iterate(List<NestedInteger> nList, LinkedList<Integer> q)
    {
        for (NestedInteger ni: nList)
        {
            if (ni.isInteger())
                q.add(ni.getInteger());
            else
                iterate(ni.getList(), q);
        }
    }

    @Override
    public Integer next()
    {
        return queue.get(++index);
    }

    @Override
    public boolean hasNext()
    {
        return index + 1 < sz;
    }
}
