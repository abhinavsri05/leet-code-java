package n07_recursion_backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC0090SubsetsII {
    // Attempt 1 (Sorts the input first)
    LinkedList<List<Integer>> output;

    void backtrack(int start, int[] nums, LinkedList<Integer> temp)
    {
        if (start == nums.length) return;

        for(int i = start; i < nums.length; i++)
        {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.addLast(nums[i]);
            output.add(new LinkedList<Integer>(temp));
            backtrack(i + 1, nums, temp);
            temp.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        output = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();

        output.add(new LinkedList<>());

        Arrays.sort(nums);

        backtrack(0, nums, temp);

        return output;
    }


}
