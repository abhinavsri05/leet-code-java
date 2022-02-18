package n07_recursion_backtracking;

import java.util.LinkedList;
import java.util.List;

public class LC0039CombinationSum {
    private List<List<Integer>> output = new LinkedList<>();

    private void getCombinationSum(int[] candidates, int target, LinkedList<Integer> temp, int start, int sum)
    {
        if (start == candidates.length)
            return;
        if (sum == target)
        {
            output.add(new LinkedList<Integer>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++)
        {
            if (sum < target)
            {
                sum += candidates[i];
                temp.add(candidates[i]);
                getCombinationSum(candidates, target, temp, i, sum);
                sum -= candidates[i];
                temp.removeLast();
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        LinkedList<Integer> temp = new LinkedList<>();

        getCombinationSum(candidates, target, temp, 0, 0);

        return output;
    }
}
