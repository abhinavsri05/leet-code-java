package leet_code_contests.weekly.wc291_20220430;

import java.util.HashMap;

public class LC2260MinimumConsecutiveCardsToPickUp
{
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        int i;
        int minCons = 100_001;

        for (i = 0; i < cards.length; i++)
        {
            if (seen.containsKey(cards[i]))
            {
                minCons = Math.min(minCons, i - seen.get(cards[i]) + 1);
            }

            seen.put(cards[i], i);
        }

        return minCons == 100_001 ? -1 : minCons;

    }
}
