package n04_greedy_random;

import java.util.Arrays;

public class LC0881BoatsToSavePeople {
    // Attempt 1
    public int numRescueBoats1(int[] people, int limit) {
        //Not knapsack since every given person needs to be carried

        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;

        int count = 0;

        while (l <= r)
        {
            if (people[l] + people[r] <= limit)
            {
                l++;
                r--;;
            }
            else
            {
                r--;
            }
            count ++;
        }
        return count;

    }

    // Attempt 2

    public int numRescueBoats(int[] people, int limit) {
        //Not knapsack since every given person needs to be carried

        Arrays.sort(people);

        int l = 0;
        int r = people.length - 1;

        int count = 0;

        while (l <= r)
        {
            if (people[l] + people[r] <= limit)
                l++;
            r--;
            count ++;
        }
        return count;
    }

}
