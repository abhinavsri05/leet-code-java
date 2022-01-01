package n07_recursion_backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P0046Permutation {
    private void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first)
    {
        if (first == n) output.add(new ArrayList<Integer>(nums));

        for (int i = first; i < n; i++)
        {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList();
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i : nums)
            newList.add(i);
        backtrack(nums.length, newList, output, 0);
        return output;
    }
}
