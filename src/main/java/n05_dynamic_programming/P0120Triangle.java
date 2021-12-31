package n05_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class P0120Triangle {

    // Using ArrayList o(n^2) space
//    public int minimumTotal(List<List<Integer>> triangle)
//    {
//        int n = triangle.size();
//        int i, j;
//        List<List<Integer>> minPathSum = new ArrayList<List<Integer>>();
//        ArrayList<Integer> arr;
//        arr = new ArrayList<Integer>();
//        arr.add(0,triangle.get(0).get(0));
//        minPathSum.add(0, arr);
//
//        int minValue = arr.get(0);
//        int val;
//
//        for (i = 1; i < n; i++)
//        {
//            minValue = Integer.MAX_VALUE;
//            arr = new ArrayList<Integer>();
//
//            for (j = 0; j <= i; j++)
//            {
//                if (j == 0)
//                {
//                    val = minPathSum.get(i - 1).get(j) + triangle.get(i).get(j);
//                    arr.add(j, val);
//                    minValue = Math.min(minValue, val);
//                }
//                else if (j == i)
//                {
//                    val = minPathSum.get(i - 1).get(j - 1) + triangle.get(i).get(j);
//                    arr.add(j, val);
//                    minValue = Math.min(minValue, val);
//                }
//                else
//                {
//                    val = Math.min(minPathSum.get(i - 1).get(j) + triangle.get(i).get(j), minPathSum.get(i - 1).get(j - 1) + triangle.get(i).get(j));
//                    arr.add(j, val);
//                    minValue = Math.min(minValue, val);
//
//                }
//
//            }
//            minPathSum.add(i, arr);
//        }
//        return minValue;
//
//    }

    // Using array O(n) space
//    public int minimumTotal(List<List<Integer>> triangle)
//    {
//        int n = triangle.size();
//        int i, j;
//        int[][] minPathSum = new int[2][n];
//
//        minPathSum[0][0] = triangle.get(0).get(0);
//
//        int minValue = minPathSum[0][0];
//        int val;
//        int prev = 0;
//        int curr = 1;
//
//        for (i = 1; i < n; i++)
//        {
//            minValue = Integer.MAX_VALUE;
//
//            for (j = 0; j <= i; j++)
//            {
//                if (j == 0)
//                    val = minPathSum[prev][j];
//                else if (j == i)
//                    val = minPathSum[prev][j - 1];
//                else
//                    val = Math.min(minPathSum[prev][j], minPathSum[prev][j - 1]);
//
//                minPathSum[curr][j] = val + triangle.get(i).get(j);
//                minValue = Math.min(minValue, minPathSum[curr][j]);
//            }
//            prev = (prev + 1) % 2;
//            curr = (curr + 1) % 2;
//        }
//        return minValue;
//
//    }

    // In place updates  O(1) space
    public int minimumTotal(List<List<Integer>> triangle)
    {
        int i, j;
        int minValue = triangle.get(0).get(0);
        int val;

        for (i = 1; i < triangle.size(); i++)
        {
            minValue = Integer.MAX_VALUE;
            for (j = 0; j <= i; j++)
            {
                if (j == 0)
                    val = triangle.get(i - 1).get(j) + triangle.get(i).get(j);
                else if (j == i)
                    val = triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j);
                else
                    val = Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)) + triangle.get(i).get(j);

                minValue = Math.min(minValue, val);
                triangle.get(i).set(j, val);
            }
        }
        return minValue;

    }


}
