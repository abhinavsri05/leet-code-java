package n03_graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class LC1376TimeNeededToInformAllEmployees
{
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime)
    {
        HashMap<Integer, ArrayList<Integer>> directs = new HashMap<>(); // This is basically an adjacency list of a directed graph

        for (int i = 0; i < n; i++)
        {
            ArrayList<Integer> d = directs.getOrDefault(manager[i], new ArrayList<>());
            d.add(i);
            directs.put(manager[i], d);
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int time = informTime[headID];

        q.add(new int[]{headID, time});

        int[] top;

        while (!q.isEmpty())
        {
            top = q.poll();
            time = Math.max(time, top[1]);
            if (directs.containsKey(top[0]))
            {
                for (Integer em: directs.get(top[0]))
                {
                    q.add(new int[]{em, top[1] + informTime[em]});
                }
            }
        }

        return time;
    }
}
