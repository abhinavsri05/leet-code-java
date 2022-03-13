package leet_code_contests.weekly.wc284_20220312;

public class LC2201CountArtifactsThatCanBeExtracted {
    // Attempt 1
    public int digArtifacts1(int n, int[][] artifacts, int[][] dig) {
        boolean[][] grid = new boolean[n][n];
        int count = 0;
        int i, j;
        boolean extracted;

        for (int[] d: dig)
        {
            grid[d[0]][d[1]] = true;
        }

        for (int[] a: artifacts)
        {
            extracted = true;
            for (i = a[0]; i <= a[2]; i++)
            {
                for (j = a[1]; j <= a[3]; j++)
                {
                    if (!grid[i][j])
                    {
                        extracted = false;
                        break;
                    }
                }
                if (!extracted) break;
            }
            if (extracted) count++;
        }

        return count;

    }

    // Attempt 2: Break out of more than 2 loops
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] grid = new boolean[n][n];
        int count = 0;
        int i, j;

        for (int[] d: dig)
            grid[d[0]][d[1]] = true;

        outer_loop:
        for (int[] a: artifacts)
        {
            for (i = a[0]; i <= a[2]; i++)
            {
                for (j = a[1]; j <= a[3]; j++)
                {
                    if (!grid[i][j])
                    {
                        continue outer_loop;
                    }
                }
            }
            count++;
        }

        return count;

    }
}
