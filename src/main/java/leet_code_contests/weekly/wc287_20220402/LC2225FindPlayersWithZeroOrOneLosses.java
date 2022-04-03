package leet_code_contests.weekly.wc287_20220402;

import java.util.*;

public class LC2225FindPlayersWithZeroOrOneLosses
{
    public List<List<Integer>> findWinners(int[][] matches)
    {
        // PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((i, j) -> (i.get(3) - i.get(1)) - (j.get(3) - j.get(1)));
        List<Integer> zeroLoss = new LinkedList<>();
        List<Integer> oneLoss = new LinkedList<>();
        List<List<Integer>> output = new LinkedList<>();

        HashMap<Integer, ArrayList<Integer>> result = new HashMap<>();
        ArrayList<Integer> res;

        // Win
            for (int[] r: matches)
        {
            if (result.containsKey(r[0]))
            {
                res = result.get(r[0]);
                // pq.remove(res);
                res.set(1, res.get(1) + 1);
                res.set(3, res.get(3) + 1);
                // pq.add(res);
                // String str = Arrays.toString(res.toArray());
                // System.out.println("Win: Updated " + str);
            }
            if (!result.containsKey(r[0]))
            {
                res = new ArrayList<>();
                res.add(r[0]);
                res.add(1);
                res.add(0);
                res.add(1);
                result.put(r[0], res);
                // pq.add(res);
                // String str = Arrays.toString(res.toArray());
                // System.out.println("Win: Added " + str);
            }
            if (result.containsKey(r[1]))
            {
                res = result.get(r[1]);
                // pq.remove(res);
                res.set(2, res.get(2) + 1);
                res.set(3, res.get(3) + 1);
                // pq.add(res);
                // String str = Arrays.toString(res.toArray());
                // System.out.println("Loss: Updated " + str);
            }
            if (!result.containsKey(r[1]))
            {
                res = new ArrayList<>();
                res.add(r[1]);
                res.add(0);
                res.add(1);
                res.add(1);
                result.put(r[1], res);
                // pq.add(res);
                // String str = Arrays.toString(res.toArray());
                // System.out.println("Loss: Added " + str);
            }
        }

        // Loss
    //         for (int[] r: matches)
    //         {
    //             if (result.containsKey(r[1]))
    //             {
    //                 res = result.get(r[1]);
    //                 pq.remove(res);
    //                 res.set(2, res.get(2) + 1);
    //                 res.set(3, res.get(3) + 1);
    //                 pq.add(res);
    //                 // String str = Arrays.toString(res.toArray());
    //                 // System.out.println("Loss: Updated " + str);
    //             }
    //             else
    //             {
    //                 res = new ArrayList<>();
    //                 res.add(r[1]);
    //                 res.add(0);
    //                 res.add(1);
    //                 res.add(1);
    //                 result.put(r[1], res);
    //                 pq.add(res);
    //                 // String str = Arrays.toString(res.toArray());
    //                 // System.out.println("Loss: Added " + str);
    //             }

    //         }

    //         while (!pq.isEmpty())
    //         {
    //             res = pq.poll();
    //             // String str = Arrays.toString(res.toArray());
    //             // System.out.println("PQ: Top " + str);
    //             if (res.get(3) - res.get(1) > 1)
    //                 break;
    //             if (res.get(3) - res.get(1) == 0)
    //                 zeroLoss.add(res.get(0));
    //             if (res.get(3) - res.get(1) == 1)
    //                 oneLoss.add(res.get(0));

    //         }

            for (Integer key : result.keySet())
        {
            res = result.get(key);
            if (res.get(3) - res.get(1) > 1)
                continue;
            if (res.get(3) - res.get(1) == 0)
                zeroLoss.add(res.get(0));
            if (res.get(3) - res.get(1) == 1)
                oneLoss.add(res.get(0));
        }
            Collections.sort(zeroLoss);
            Collections.sort(oneLoss);
            output.add(zeroLoss);
            output.add(oneLoss);
            return output;

    }
}
