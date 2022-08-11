package n03_graphs;

import java.util.List;

public class LC0841KeysAndRooms
{
    private void dfs(List<List<Integer>> rooms, boolean[] visited, int room)
    {
        visited[room] = true;

        for (int r: rooms.get(room))
        {
            if (!visited[r]) dfs(rooms, visited, r);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms)
    {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(rooms, visited, 0);

        for (int i = 0; i < n; i++)
        {
            if (!visited[i]) return false;
        }

        return true;
    }
}
