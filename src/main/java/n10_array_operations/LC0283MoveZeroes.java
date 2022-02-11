package n10_array_operations;

public class LC0283MoveZeroes {
    public void moveZeroes(int[] nums)
    {
        // Keep it simple. Start with think how would you do it with an auxiliary array.

        int i;
        int lastNonZero = 0;

        for (i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[lastNonZero++] = nums[i];

        for (i = lastNonZero; i < nums.length; i++)
            nums[i] = 0;
    }


}
