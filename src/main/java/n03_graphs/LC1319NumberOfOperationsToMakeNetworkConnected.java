package n03_graphs;

import java.util.LinkedList;
import java.util.List;

public class LC1319NumberOfOperationsToMakeNetworkConnected
{
    private void dfs(List<Integer>[] adjList, int node, boolean[] visited)
    {
        if (visited[node]) return;
        visited[node] = true;

        for (int v: adjList[node])
        {
            dfs(adjList, v, visited);
        }
    }


    public int makeConnected(int n, int[][] connections)
    {
        int m = connections.length;
        if (m < (n - 1)) return -1; // not enough edges to connect all nodes

        int i, j;
        // Create Adjacency List

        List<Integer>[] adjList = new LinkedList[n];
        for (i = 0; i < n; i++)
        {
            adjList[i] = new LinkedList<>();
        }

        for (j = 0; j < m; j++)
        {
            adjList[connections[j][0]].add(connections[j][1]);
            adjList[connections[j][1]].add(connections[j][0]);
        }

        // Count connected components
        boolean[] visited = new boolean[n];
        int cc = 0;

        for (i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                cc++;
                dfs(adjList, i, visited);
            }

        }

        return cc - 1;
    }
}
