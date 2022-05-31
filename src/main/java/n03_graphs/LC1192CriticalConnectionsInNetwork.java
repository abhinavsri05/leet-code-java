package n03_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC1192CriticalConnectionsInNetwork
{
    private int time = 0;

    private ArrayList<Integer>[] getAdjacencList(int n, List<List<Integer>> connections)
    {
        ArrayList<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adjList[i] = new ArrayList<Integer>();

        for (List<Integer> edge: connections)
        {
            adjList[edge.get(0)].add(edge.get(1));
            adjList[edge.get(1)].add(edge.get(0));
        }

        return adjList;
    }

    public void dfs(ArrayList<Integer>[] adjList, int vertex, int[] pre, int[] post, int[] low, boolean[] visited, int grandParent, List<List<Integer>> critical)
    {
        visited[vertex] = true;

        pre[vertex] = low[vertex] = time++;

        for (Integer adjVertex: adjList[vertex])
        {
            if (!visited[adjVertex])
            {
                dfs(adjList, adjVertex, pre, post, low, visited, vertex, critical);
                low[vertex] = Math.min(low[vertex], low[adjVertex]);
                if (low[adjVertex] > pre[vertex])
                    critical.add(new LinkedList(Arrays.asList(vertex, adjVertex)));
            }
            else
            {
                if (adjVertex != grandParent)
                    low[vertex] = Math.min(low[vertex], pre[adjVertex]);
            }

        }
        post[vertex] = time++;

    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // The problem is to find bridge or cut edges in a graph
        // Refer Jeff Erickson's book
        // Edge is a bridge if low(v) > pre(v)
        // https://www.geeksforgeeks.org/bridge-in-a-graph/

        ArrayList<Integer>[] adjList = getAdjacencList(n, connections);
        List<List<Integer>> critical = new LinkedList<>();

        int[] pre = new int[n];
        int[] post = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                dfs(adjList, i, pre, post, low, visited, -1, critical);
            }
        }

        // for (List<Integer> edge: connections)
        // {
        //     if (low[edge.get(0)] > pre[edge.get(1)] || low[edge.get(1)] > pre[edge.get(0)])
        //     {
        //         critical.add(new LinkedList<>(edge));
        //     }
        // }

        return critical;
    }
}
