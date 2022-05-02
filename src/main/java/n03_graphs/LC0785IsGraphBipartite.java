package n03_graphs;

import java.util.Arrays;

public class LC0785IsGraphBipartite
{
    private boolean dfs(int[][] graph, int node, boolean[] visited, int[] color)
    {
        if (visited[node]) return true;
        visited[node] = true;
        boolean ret = true;
        for (int n: graph[node])
        {
            if (color[n] == color[node])
                return false;
            else
                color[n] = (color[node] + 1) & 1;

            ret = dfs(graph, n, visited, color);
            if (!ret) return false;
        }
        return ret;
    }

    public boolean isBipartite(int[][] graph)
    {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] color = new int[n];
        Arrays.fill(color, 2);
        boolean ret;

        for (int i = 0; i < n; i++)
        {
            if (!visited[i])
            {
                color[i] = 0;
                ret = dfs(graph, i, visited, color);
                if (!ret) return false;
            }
        }

        return true;
    }
}
