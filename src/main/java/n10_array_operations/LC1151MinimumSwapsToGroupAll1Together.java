package n10_array_operations;

import java.util.Arrays;

public class LC1151MinimumSwapsToGroupAll1Together
{
    public int minSwaps(int[] data)
    {
        /*
        Count the number of ones in the array
        Create a sliding window of this length
        The window with most ones will need least swaps
        */

        // int countOnes = 0;
        // for (int i = 0; i < data.length; i++)
        //     countOnes += data[i];

        int countOnes = Arrays.stream(data).sum();

        int left = 0, right = 0;
        int onesInWindow = 0;
        int minSwaps = countOnes;

        while (right < data.length)
        {
            onesInWindow += data[right];
            if (right - left + 1 == countOnes)
            {
                System.out.println(onesInWindow);
                minSwaps = Math.min(minSwaps, countOnes - onesInWindow);
                onesInWindow -= data[left++];
            }
            right++;
        }
        return minSwaps;
    }
}
