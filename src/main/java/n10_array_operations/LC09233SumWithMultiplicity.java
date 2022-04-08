package n10_array_operations;

import java.util.Arrays;

public class LC09233SumWithMultiplicity
{
    // LC Solution
    public int threeSumMulti(int[] arr, int target) {
        long count = 0;
        long modulo = 1_000_000_000 + 7;
        Arrays.sort(arr);
        int n = arr.length;
        int i, j, p1, p2;
        int newTarget;
        int leftCount, rightCount;

        for (i = 0; i < n - 2; i++)
        {
            p1 = i + 1;
            p2 = n - 1;
            newTarget = target - arr[i];

            while (p1 < p2)
            {
                if (arr[p1] + arr[p2] < newTarget)
                    p1++;
                else
                {
                    if (arr[p1] + arr[p2] > newTarget)
                        p2--;
                    else // arr[p1] + arr[p2] == target
                    {
                        if (arr[p1] != arr[p2])
                        {
                            leftCount = 1;
                            rightCount = 1;
                            while (p1 + 1 < p2 && arr[p1] == arr[p1 + 1])
                            {
                                p1++;
                                leftCount++;
                            }
                            while (p2 - 1 > p1 && arr[p2] == arr[p2 - 1])
                            {
                                p2--;
                                rightCount++;
                            }
                            count += (leftCount * rightCount);
                            count %= modulo;
                            p1++;
                            p2--;
                        }
                        else // arr[p1] == arr[p2]
                        {
                            count += (p2 - p1 + 1) * (p2 - p1) / 2; // total p2 - p1 + 1 numbers and each pair gets counted once
                            count %= modulo;
                            break;
                        }
                    }
                }
            }
        }
        return (int)(count);

    }
}
