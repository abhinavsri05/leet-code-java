package n10_array_operations;

public class P0977SquaresOfSortedArray {
    public static int[] sortedSquares(int[] nums)
    {
        /* Solution 1

        int[] squares = new int[nums.length];
        int p = nums.length - 1;
        int q = 0;
        int i;

        if (nums[0] > 0)
        {
            p = -1;
            q = 0;
        }
        else
        {
            if (nums[nums.length - 1] < 0)
            {
                p = nums.length - 1;
                q = nums.length;
            }

            else
            {
                for (i = 1; i < nums.length; i++)
                {
                    if (nums[i - 1] < 0 && nums[i] >= 0 )
                    {
                        q = i;
                        p = i - 1;
                        break;
                    }
                }
            }
        }

        System.out.println(p + " " + q);

        i = 0;

        while (i < nums.length)
        {
            if (p >= 0 && q < nums.length && Math.abs(nums[p]) < Math.abs(nums[q]))
            {
                squares[i++] = nums[p] * nums[p];
                p--;
            }
            else
            {
                if (p >= 0 && q < nums.length && Math.abs(nums[p]) >= Math.abs(nums[q]))
                {
                    squares[i++] = nums[q] * nums[q];
                    q++;
                }
                else
                {
                    if (p < 0)
                    {
                        for (; q < nums.length;)
                        {
                            squares[i++] = nums[q] * nums[q];
                            q++;
                        }
                    }
                    else
                    {
                        if (q >= nums.length)
                        {
                            for (; p >= 0;)
                            {
                                squares[i++] = nums[p] * nums[p];
                                p--;
                            }
                        }
                    }
                }
            }

        }
        return squares;

         */

        /* Solution 2 (Does not work)

        For solution#2. The loop from 0 to n - 1 does not work since we cannot say for sure if the first element
        is the smallest in absolute value but we know that the first or the last will be the biggest in absolute value.
        So loop should be in reverse order.

        int[] squares = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i;

        for (i = 0; i < nums.length; i++)
        {
            if (Math.abs(nums[left]) < Math.abs(nums[right]))
            {
                squares[i] = nums[left] * nums[left];
                left++;
            }
            else
            {
                squares[i] = nums[right] * nums[right];
                right--;
            }
        }

        return squares;
        */
        /* Solution 3 */

        int[] squares = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int i;

        for (i = nums.length - 1; i >= 0; i--)
        {
            if (Math.abs(nums[left]) < Math.abs(nums[right]))
            {
                squares[i] = nums[right] * nums[right];
                right--;
            }
            else
            {
                squares[i] = nums[left] * nums[left];
                left++;
            }
        }

        return squares;





    }

    public static void main(String[] args) {
        int[] inpt = {-4, -1, 0, 3, 10};
        int[] oput = sortedSquares(inpt);

        for (int i = 0; i < oput.length; i++)
        {
            System.out.println(oput[i]);
        }

    }
}
