package n05_dynamic_programming;

public class LC0376WiggleSubsequence
{
    public int wiggleMaxLength(int[] nums)
    {
        int n = nums.length;
        int[] positive = new int[n];
        int[] negative = new int[n];
        positive[0] = 1;
        negative[0] = 1;

        int i;

        for(i = 1; i < n; i++)
        {
            if (nums[i] > nums[i - 1]) {
                positive[i] = negative[i - 1] + 1;
                negative[i] = negative[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                negative[i] = positive[i - 1] + 1;
                positive[i] = positive[i - 1];
            } else {
                negative[i] = negative[i - 1];
                positive[i] = positive[i - 1];
            }
        }
        return Math.max(positive[nums.length - 1], negative[nums.length - 1]);
    }
}
