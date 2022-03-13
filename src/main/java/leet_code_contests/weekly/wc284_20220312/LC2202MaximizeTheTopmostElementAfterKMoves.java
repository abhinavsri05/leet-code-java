package leet_code_contests.weekly.wc284_20220312;

public class LC2202MaximizeTheTopmostElementAfterKMoves {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        int top = -1;

        if (nums.length == 1 && k % 2 == 1) return -1;  // This step is needed

        int i;
        int maxNum = -1;

        for (i = 0; i < n; i++)
        {
            if (i < k - 1)
                maxNum = Math.max(maxNum, nums[i]);
            else
                break;
        }

        if (k < n)
            top = nums[k];

        return Math.max(maxNum, top);
    }
}
