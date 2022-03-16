package n07_recursion_backtracking;

import java.util.LinkedList;
import java.util.List;

public class LC0078Subsets {
    private void backtrack(int[] nums, int start, LinkedList<List<Integer>> output, LinkedList<Integer> temp)
    {
        if (nums.length == start) return;

        // This loop defines how values are added
        for (int i = start; i < nums.length; i++)
        {
            temp.addLast(nums[i]);
            output.add(new LinkedList<Integer>(temp));
            backtrack(nums, i + 1, output, temp);
            temp.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> output = new LinkedList<>();
        output.add(new LinkedList<Integer>());
        LinkedList<Integer> temp = new LinkedList<>();

        backtrack(nums, 0, output, temp);

        return output;
    }

}
