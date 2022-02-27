package n10_array_operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC00153Sum {
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int lt, rt;
        int j;

        for (int i = 0; i < nums.length; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            lt = i + 1;
            rt = nums.length - 1;
            while (lt < rt)
            {
                if (nums[i] + nums[lt] + nums[rt] == 0)
                {
                    ArrayList<Integer> soln = new ArrayList<>();
                    soln.add(nums[i]);
                    soln.add(nums[lt]);
                    soln.add(nums[rt]);
                    output.add(soln);
                    while (lt < nums.length - 1 && nums[lt] == nums[++lt]);
                    while (rt > 1 && nums[rt] == nums[--rt]);
                }
                else
                {
                    if (nums[i] + nums[lt] + nums[rt] < 0)
                        while (lt < nums.length - 1 && nums[lt] == nums[++lt]);
                    else
                        while (rt > 1 && nums[rt] == nums[--rt]);
                }
            }
        }
        return output;
    }
}
