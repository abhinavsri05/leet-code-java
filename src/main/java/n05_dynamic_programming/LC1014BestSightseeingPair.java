package n05_dynamic_programming;

public class LC1014BestSightseeingPair
{
    public int maxScoreSightseeingPair(int[] values) {

        // Note value[i] + i is always added

        int maxValue = 0;
        int j;
        int i = 0;
        for (j = 1; j < values.length; j++)
        {
            maxValue = Math.max(maxValue, values[i] + values[j] + i - j);
            if (values[i] + i < values[j] + j) i = j;
        }
        return maxValue;
    }
}
