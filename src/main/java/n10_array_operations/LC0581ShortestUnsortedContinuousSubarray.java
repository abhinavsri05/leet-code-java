package n10_array_operations;

public class LC0581ShortestUnsortedContinuousSubarray
{
    // First attempt - 2 pointer approach that works if there are no repeats
    /*
        public int findUnsortedSubarray(int[] nums)
    {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int count = 0;
        int sRepeat = 0;
        int eRepeat = n - 1;
        boolean startProgressed, endProgressed;

        while (start < end)
        {
            startProgressed = false;
            endProgressed = false;
            if (nums[start] < nums[start + 1])
            {
                start++;
                count = 0;
                startProgressed = true;
            }
            else
            {
                if (nums[start] == nums[start + 1] && nums[sRepeat] != nums[start])
                {
                    count += start - sRepeat;
                    sRepeat = start++;
                    startProgressed = true;
                }
            }

            if (nums[end] > nums[end - 1])
            {
                end--;
                count = 0;
                endProgressed = true;
            }
            else
            {
                if (nums[end] == nums[end - 1] && nums[eRepeat] != nums[end])
                {
                    count += eRepeat - end;
                    eRepeat = end--;
                    endProgressed = true;
                }
            }

            if (!startProgressed && !endProgressed) break;
        }

        return start == end ? 0 : count + end - start + 1;
    }
     */

    // From solution discussion
    public int findUnsortedSubarray(int[] nums)
    {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int start = 0;
        int end = -1;

        while (right >= 0)
        {
            if (nums[left] >= max)
                max = nums[left];
            else
                end = left;

            if (nums[right] <= min)
                min = nums[right];
            else
                start = right;
            left++;
            right--;
        }

        return end - start + 1;
    }
}
