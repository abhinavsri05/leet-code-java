package n10_array_operations;

import java.util.LinkedList;
import java.util.List;

public class LC0228SummaryRanges {
    public List<String> summaryRanges1(int[] nums) {
        List<String> output = new LinkedList<>();
        int s = 0;

        for (int i = 0; i < nums.length; i++)
        {
            // The difference operation wil overflow for input: [-2147483648,-2147483647,2147483647] so a negative check condition is required

            if (i == 0 || nums[i] - nums[i - 1] > 1 || nums[i] - nums[i - 1] < 0)
                s = nums[i];

            if (i == nums.length - 1 || nums[i + 1] - nums[i] > 1 || nums[i + 1] - nums[i] < 0)
            {
                if (s != nums[i])
                    output.add(String.format("%d->%d", s, nums[i]));
                else
                    output.add(String.format("%d", s));
            }
        }

        return output;

    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> output = new LinkedList<>();
        int s = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (i == 0 || nums[i] - nums[i - 1] != 1)
                s = nums[i];

            if (i == nums.length - 1 || nums[i + 1] - nums[i] != 1)
            {
                if (s != nums[i])
                    output.add(String.format("%d->%d", s, nums[i]));
                else
                    output.add(String.format("%d", s));
            }
        }

        return output;

    }
}
