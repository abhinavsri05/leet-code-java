/*
Hard (LC 2183)

Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) such that:

0 <= i < j <= n - 1 and
nums[i] * nums[j] is divisible by k.


Example 1:

Input: nums = [1,2,3,4,5], k = 2
Output: 7
Explanation:
The 7 pairs of indices whose corresponding products are divisible by 2 are
(0, 1), (0, 3), (1, 2), (1, 3), (1, 4), (2, 3), and (3, 4).
Their products are 2, 4, 6, 8, 10, 12, and 20 respectively.
Other pairs such as (0, 2) and (2, 4) have products 3 and 15 respectively, which are not divisible by 2.
Example 2:

Input: nums = [1,2,3,4], k = 5
Output: 0
Explanation: There does not exist any pair of indices whose corresponding product is divisible by 5.


Constraints:

1 <= nums.length <= 10^5
1 <= nums[i], k <= 10^5


Check: 1497. Check If Array Pairs Are Divisible by k
LC 2183
 */

package leet_code_contests.weekly.wc281_20220219;

import java.util.HashMap;

public class LC6015CountArrayPairsDivisibleByK {
    /* My Attempt
    Does not work for :
    [8,10,2,5,9,6,3,8,2]
    6

    Expected: 18
     */
    public long coutPairs(int[] nums, int k) {
        long count = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();
        int factors = 0;
        int mod;

        for (int num: nums)
        {
            mod = num % k;

            if (mod == 0) {
                count += nums.length - 1 - factors;
                factors++;
            }
            else if (k % mod == 0 && seen.containsKey(k / mod))
            {
                count += seen.get(k/mod);
            }

            if (mod != 0)
            {
                if (seen.containsKey(k / mod))
                    seen.put(mod, seen.get(k/mod) + 1);
                else
                    seen.put(mod, 1);
            }
        }
        return count;

    }

}
