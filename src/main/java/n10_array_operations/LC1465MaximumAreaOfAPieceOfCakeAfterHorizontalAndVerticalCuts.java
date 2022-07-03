package n10_array_operations;

import java.util.Arrays;

public class LC1465MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts
{
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxHeight = horizontalCuts[0];
        long maxWidth = verticalCuts[0];

        int i;
        int hLength = horizontalCuts.length;
        int vLength = verticalCuts.length;

        for (i = 1; i < hLength ; i++)
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        maxHeight = Math.max(maxHeight, h - horizontalCuts[i - 1]);

        for (i = 1; i < vLength ; i++)
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        maxWidth = Math.max(maxWidth, w - verticalCuts[i - 1]);

        return (int)((maxHeight * maxWidth) % 1_000_000_007);
    }
}
