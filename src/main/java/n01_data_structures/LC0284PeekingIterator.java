package n01_data_structures;

import java.util.Iterator;

public class LC0284PeekingIterator implements Iterator<Integer>
{
    private Iterator<Integer> it;
    private Integer curr;
    public LC0284PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        curr = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek()
    {
        if (curr == null)
        {
            curr = it.next();
        }
        return curr;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next()
    {
        if (curr != null)
        {
            Integer ret = curr;
            curr = null;
            return ret;
        }
        return it.next();
    }

    @Override
    public boolean hasNext()
    {
        return curr != null || it.hasNext();
    }
}
