package n05_dynamic_programming;

public class P0198HouseRobber {
    public int rob(int[] nums) {
        int best_i = nums[0];
        int best_i_1 = 0;
        int temp;
        for (int i = 1; i < nums.length; i++)
        {
            temp = best_i;
            best_i = Math.max(temp, best_i_1 + nums[i]);
            best_i_1 = temp;
        }

        return best_i;

    }
}
