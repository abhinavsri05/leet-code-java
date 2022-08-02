package n10_array_operations;

// Using Segmentation Tree
public class LC0307RangeSumQueryMutable
{
    private final int[] segmentTree;
    private final int n;

    public LC0307RangeSumQueryMutable(int[] nums)
    {
        this.n = nums.length;
        this.segmentTree = new int[4 * this.n];
        // The actual size would be 2 * ceil (2 ^ log n) - 1. works perfectly if n is a power of 2 but when it is not then we need an upper bound since calculating log is not easy.
        // Think of 9 (2^3 + 1), we would need 9 leafs, + 5 parents + 3 grand parents + 2 + great grand parents and 1 root = 9 + 5 + 3 + 2 + 1 = 20 nodes. More than 2 * 9.
        // Now if n = 7 (2 ^ 3  - 1), we would need 7 + 4 + 2 + 1 = 14 = 2 * 7

        // So easiest is to bring number of leaf nodes to next power of 2. Which is less than 2n and then we need to add 2n - 1 nodes to this. This gives upper bound of 4n
        buildSegmentTree(0, this.n - 1, 0, nums);
    }

    public void update(int index, int val)
    {
        // Add delta to to 'index' and all its parents.
        updateSegmentTree(0, this.n - 1, 0, index, val);
    }

    public int sumRange(int left, int right)
    {
        return getSum(0, this.n - 1, 0, left, right);
    }

    private int buildSegmentTree(int start, int end, int idx, int[] nums)
    {
        // ids is the index in segment tree. This can be upto 4n - 1

        if (start == end) // leaf node
        {
            segmentTree[idx] = nums[start];
            return segmentTree[idx];
        }

        int mid = start + (end - start) / 2;

        segmentTree[idx] = buildSegmentTree(start, mid, 2 * idx + 1, nums) +
                buildSegmentTree(mid + 1, end, 2 * idx + 2, nums);

        return segmentTree[idx];
    }

    private void updateSegmentTree(int start, int end, int idx, int updIdx, int updVal)
    {
        if (start == end && start == updIdx)
        {
            segmentTree[idx] = updVal;
            return;
        }

        int mid = start + (end - start) / 2;

        if (updIdx <= mid)
        {
            updateSegmentTree(start, mid, 2 * idx + 1, updIdx, updVal);
        }
        else
        {
            updateSegmentTree(mid + 1, end, 2 * idx + 2, updIdx, updVal);
        }

        segmentTree[idx] = segmentTree[2 * idx + 1] + segmentTree[2 * idx + 2];
    }

    private int getSum(int start, int end, int idx, int left, int right)
    {
        if (start == left && end == right)
            return segmentTree[idx];

        int mid = start + (end - start) / 2;

        if (right <= mid)
        {
            return getSum(start, mid, 2 * idx + 1, left, right);
        }

        if (left > mid)
        {
            return getSum(mid + 1, end, 2 * idx + 2, left, right);
        }

        return getSum(start, mid, 2 * idx + 1, left, mid) +
                getSum(mid + 1, end, 2 * idx + 2, mid + 1, right);
    }
}

// Using Binary Indexed Tree

class NumArray {
    private final int[] bit;
    private final int[] nums;
    private final int n;

    public NumArray(int[] nums)
    {
        this.n = nums.length;
        this.nums = nums;
        this.bit = new int[this.n + 1];

        for (int i = 0; i < this.n; i++)
        {
            updateBinaryIndexedTree(i, nums[i]);
        }
    }

    public void update(int index, int val)
    {
        updateBinaryIndexedTree(index, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right)
    {
        return getPrefixSumBinaryIndexedTree(right) - getPrefixSumBinaryIndexedTree(left - 1);
    }


    private void updateBinaryIndexedTree(int index, int diff)
    {
        index++;

        while (index <= this.n)
        {
            bit[index] += diff;
            index = index + (index & (-index));
        }
    }

    private int getPrefixSumBinaryIndexedTree(int end)
    {
        // Get prefix sum of 0 to end;
        end++;

        int res = 0;

        while (end > 0)
        {
            res += bit[end];
            end = end - (end & (-end));
        }
        return res;
    }
}