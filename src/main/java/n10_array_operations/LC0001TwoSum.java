package n10_array_operations;

import java.util.HashMap;

public class LC0001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> elementSeen = new HashMap<>();  // value, index

        for (int i = 0; i < nums.length; i++)
        {
            if (elementSeen.containsKey(target - nums[i]))
                return new int[]{elementSeen.get(target - nums[i]), i};
            elementSeen.put(nums[i], i);
        }
        return null;
    }
}
