package n10_array_operations;

public class LC0169MajorityElement {

    // Boyer-Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int sum = 0;
        int majElement = 0;

        for (int num: nums)
        {
            if (sum == 0)
                majElement = num;

            sum += (num == majElement ? 1 : -1);
        }

        return majElement;

    }

}
