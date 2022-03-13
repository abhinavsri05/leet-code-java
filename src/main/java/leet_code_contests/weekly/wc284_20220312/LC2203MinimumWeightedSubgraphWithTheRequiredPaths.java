package leet_code_contests.weekly.wc284_20220312;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC2203MinimumWeightedSubgraphWithTheRequiredPaths {

    // In Progress
    private HashMap<Integer, ArrayList<Integer[]>> reverse(int n, int[][] edges)
    {
        HashMap<Integer, ArrayList<Integer[]>> rev = new HashMap<>();
        ArrayList<Integer[]> list;
        int start;
        for (int i = 0; i < edges.length; i++)
        {
            start = edges[i][1];
            list = rev.getOrDefault(rev.get(start), new ArrayList<Integer[]>());
            list.add(new Integer[]{edges[i][0], edges[i][2]});
            rev.put(start, list);
        }

        return rev;
    }

    private class Node
    {
        int distance;
        int node;

        public Node(int d, int n)
        {
            distance = d;
            node = n;
        }
    }

    private class NodeComparator implements Comparator<Node>
    {
        public int compare(Node one, Node two)
        {
            return Integer.compare(one.distance, two.distance);
        }
    }

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>(n, new NodeComparator());

        HashMap<Integer, ArrayList<Integer[]>> graph = reverse(n, edges);
        int[] parent = new int[n];

        pq.add(new Node(0, dest));

        while (!pq.isEmpty())
        {
            Node node = pq.poll();

        }

        return 0l;

    }
}
