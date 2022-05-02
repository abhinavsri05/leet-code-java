package n03_graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC0399EvaluateDivision
{
    private HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values)
    {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        int i;
        String v1, v2;
        HashMap<String, Double> adj1, adj2;
        for (i = 0; i < values.length; i++)
        {
            v1 = equations.get(i).get(0);
            v2 = equations.get(i).get(1);

            adj1 = graph.getOrDefault(v1, new HashMap<>());
            adj2 = graph.getOrDefault(v2, new HashMap<>());

            adj1.put(v2, values[i]);
            adj2.put(v1, 1.0d / values[i]);
            graph.put(v1, adj1);
            graph.put(v2, adj2);
        }

        return graph;
    }

    private double getPathValue(HashMap<String, HashMap<String, Double>> graph, String start, String end, HashSet<String> visited)
    {
        double ret = -1.0d;

        if (visited.contains(start)) return ret;
        visited.add(start);

        if (start.equals(end)) return 1.0d;

        HashMap<String, Double> adjacent = graph.get(start);

        // System.out.println("Start: " + start + ", End: " + end);

        for (String adj: adjacent.keySet())
        {
            // System.out.println("Adj: " + adj);

            ret = getPathValue(graph, adj, end, visited);
            if (ret != -1)
            {
                return adjacent.get(adj) * ret;
            }
        }

        return ret;

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        HashMap<String, HashMap<String, Double>> graph = buildGraph(equations, values);

        int q = queries.size();
        double[] result = new double[q];
        int i;
        String start, end;
        HashSet<String> visited;
        for (i = 0; i < q; i++)
        {
            visited = new HashSet<>();
            start = queries.get(i).get(0);
            end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end))
            {
                result[i] = -1.0d;
                continue;
            }

            if (start.equals(end))
            {
                result[i] = 1.0d;
                continue;
            }

            result[i] = getPathValue(graph, start, end, visited);
        }

        return result;
    }
}
