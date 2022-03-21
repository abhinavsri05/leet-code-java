package n04_greedy_random;

public class LC1007MinimumDominoRotationsForEqualRow {
    // Attempt 1 - Does not work
    /*
    Failed test case:

    [2,1,1,3,2,1,2,2,1]
    [3,2,3,1,3,2,3,3,2]

    public int minDominoRotations(int[] tops, int[] bottoms)
    {
        // 9:33 PM
        int n = tops.length;

        int[] rotations = new int[]{0, 0};
        int top = tops[0];
        int bottom = bottoms[0];
        boolean fail = false;

        for (int i = 1; i < n; i++)
        {
            fail = false;
            // Match top

            if (tops[i] != top)
            {
                if (bottoms[i] == top)
                    rotations[0]++;
                else
                    fail = true;
                    // Adding top = bottom; aslo does not work
            }
            // Match bottom
            if (bottoms[i] != bottom)
            {
                if(tops[i] == bottom)
                    rotations[1] ++;
                else
                    if (fail) return -1;
                    // Adding bottom = top also does not work
            }
        }
        if (rotations[0] == 0) return rotations[1];
        if (rotations[1] == 0) return rotations[0];

        return Math.min(rotations[0], rotations[1]);

    }


     */
    // Leet code solution
    private int countRotations(int val, int[] first, int[] second)
    {
        int count_first = 0;
        int count_second = 0;
        int n = first.length;

        for (int i = 0; i < n; i++)
        {
            if (first[i] != val && second[i] != val) return -1;

            if (val != first[i]) count_first ++;
            else if (val != second[i]) count_second ++;
        }

        return Math.min(count_first, count_second);

    }

    public int minDominoRotations(int[] tops, int[] bottoms)
    {
        int count = countRotations(tops[0], tops, bottoms);

        if (count != -1 || tops[0] == bottoms[0])
            return count;
        else
            return countRotations(bottoms[0], tops, bottoms);
    }

}
