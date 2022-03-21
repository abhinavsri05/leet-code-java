package leet_code_contests.weekly.wc285_20220319;

public class LC2210CountHillsAndValleysInAnArray {
    public int countHillValley(int[] nums) {
        int count = 0;
        int n = nums.length;
        if (n <= 2) return 0;
        int prev = nums[0];

        for (int i = 1; i < n - 1; i++)
        {
            if (nums[i] == prev) continue;
            if ((nums[i] > prev && nums[i] > nums[i + 1]) || (nums[i] < prev && nums[i] < nums[i + 1]))
            {
                count++;
                prev = nums[i];
            }
        }

        return count;

    }
}
