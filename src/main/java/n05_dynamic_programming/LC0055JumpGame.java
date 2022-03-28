package n05_dynamic_programming;

public class LC0055JumpGame {
    public boolean canJump(int[] nums) {
        int maxReacheable = 0;

        for (int i = 0; i < nums.length - 1; i++)
        {
            maxReacheable = Math.max(i + nums[i], maxReacheable);
            if (maxReacheable == i) break;
        }
        /*
        Following loop also works-
        for (int i = 0; i < nums.length - 1 && maxReacheable >= i; i++)
        {
            maxReacheable = Math.max(i + nums[i], maxReacheable);
        }
         */

        return maxReacheable >= nums.length - 1;
    }
}
