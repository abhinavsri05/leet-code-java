package n10_array_operations;

import java.util.Arrays;

public class LC1710MaximumUnitsOnATruck
{
    public int maximumUnits(int[][] boxTypes, int truckSize)
    {
        Arrays.sort(boxTypes, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        int units = 0;

        for (int[] box: boxTypes)
        {
            if (box[0] <= truckSize)
            {
                units += box[0] * box[1];
                truckSize -= box[0];
            }
            else
            {
                if (truckSize == 0)
                    break;
                else
                {
                    units += truckSize * box[1];
                    break;
                }

            }

        }

        return units;
    }
}
