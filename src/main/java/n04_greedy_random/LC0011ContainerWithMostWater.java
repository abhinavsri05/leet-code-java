package n04_greedy_random;

public class LC0011ContainerWithMostWater
{
    public int maxArea(int[] height) {
        int first = 0;
        int second = height.length - 1;

        int maxVol = 0;

        while (first < second)
        {
            maxVol = Math.max(maxVol, (second - first) * Math.min(height[first], height[second]));

            if (height[first] < height[second])
                first++;
            else
                second--;
        }

        return maxVol;

    }
}
