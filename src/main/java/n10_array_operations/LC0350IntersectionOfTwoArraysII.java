package n10_array_operations;

import java.util.Arrays;
import java.util.HashMap;

public class LC0350IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> elements = new HashMap<>();
        // Read first array and note frequency

        for (int ele: nums1)
        {
            if (elements.containsKey(ele))
                elements.put(ele, elements.get(ele) + 1);
            else
                elements.put(ele, 1);
        }
        int index = 0;
        for (int ele: nums2)
        {
            if (elements.containsKey(ele) && elements.get(ele) > 0)
            {
                elements.put(ele, elements.get(ele) - 1);
                nums1[index++] = ele;
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);

    }

    /*
    Follow up question-

    - What if the given array is already sorted? How would you optimize your algorithm?
    Two pointer approach. (Also suitable when output needs to be sorted) -- see intersect2()

    - What if nums1's size is small compared to nums2's size? Which algorithm is better?
    The HashMap solution where nums1 is saved into the Hash table should work.

    - What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
    The HashMap solution should work.

    From LC:
    If neither of the arrays fit into the memory, we can apply some partial processing strategies:

    Split the numeric range into subranges that fits into the memory. Modify Approach 1 to collect counts only within a given subrange, and call the method multiple times (for each subrange).

    Use an external sort for both arrays. Modify Approach 2 to load and process arrays sequentially.
     */

    public int[] intersect2(int[] nums1, int[] nums2)
    {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // int[] intersection = new int[Math.min(nums1.length, nums2.length)]; // Not needed
        int index = 0;

        int p1 = 0, p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length)
        {
            if (nums1[p1] == nums2[p2])
            {
                nums1[index++] = nums1[p1++];
                p2++;
            }
            else
            {
                if (nums1[p1] < nums2[p2])
                    p1++;
                else
                    p2++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);


    }
}
