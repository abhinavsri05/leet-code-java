package leet_code_contests.weekly.wc286_20220326;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LC2215FindTheDifferenceOfTwoArrays
{
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2)
    {
        List<List<Integer>> output = new ArrayList<>(2);

        HashSet<Integer> arr1 = new HashSet<>();
        HashSet<Integer> arr2 = new HashSet<>();

        int n1 = nums1.length;
        int n2 = nums2.length;
        int i;

        HashSet<Integer> first = new HashSet<>();
        HashSet<Integer> second = new HashSet<>();

        for (i = 0; i < n1; i++)
            arr1.add(nums1[i]);

        for (i = 0; i < n2; i++)
        {
            arr2.add(nums2[i]);
            if (!arr1.contains(nums2[i]))
                second.add(nums2[i]);
        }
        for (i = 0; i < n1; i++)
        {
            if (!arr2.contains(nums1[i]))
                first.add(nums1[i]);
        }

        output.add(new LinkedList(first));
        output.add(new LinkedList(second));
        return output;

    }
}
