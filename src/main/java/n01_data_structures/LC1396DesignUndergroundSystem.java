package n01_data_structures;

import java.util.HashMap;
import javafx.util.Pair;

public class LC1396DesignUndergroundSystem
{
    /*
    HashMap<Integer, Pair<String, Integer>> travelRecord;
    HashMap<Pair<String, String>, int[]> travelTime;

    public LC1396DesignUndergroundSystem()
    {
        travelRecord = new HashMap<>();
        travelTime = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t)
    {
        travelRecord.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t)
    {
        Pair<String, Integer> start = travelRecord.get(id);
        String startStation = start.getKey();
        int startTime = start.getValue();

        Pair<String, String> key = new Pair(startStation, stationName);

        // It's better to store the average instead of sum to avoid overflow.

        int[] time = travelTime.getOrDefault(key, new int[]{0, 0});
        time[0] += (t - startTime);
        time[1] += 1;
        travelTime.put(key, time);
    }

    public double getAverageTime(String startStation, String endStation)
    {
        Pair<String, String> key = new Pair(startStation, endStation);
        int[] time = travelTime.get(key);
        return time[0] * 1.0d / time[1];
    }
     */

    HashMap<Integer, Pair<String, Integer>> travelRecord;
    HashMap<Pair<String, String>, double[]> travelTime;

    public LC1396DesignUndergroundSystem()
    {
        travelRecord = new HashMap<>();
        travelTime = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t)
    {
        travelRecord.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t)
    {
        Pair<String, Integer> start = travelRecord.get(id);
        String startStation = start.getKey();
        int startTime = start.getValue();

        Pair<String, String> key = new Pair(startStation, stationName);

        // It's better to store the average instead of sum to avoid overflow.

        double[] time = travelTime.getOrDefault(key, new double[]{0.0d, 0.0d});
        time[0] = (time[0] * time[1] + (t - startTime)) / (time[1] + 1.0d);
        time[1] += 1.0d;
        travelTime.put(key, time);
    }

    public double getAverageTime(String startStation, String endStation)
    {
        return travelTime.get(new Pair(startStation, endStation))[0];
    }
}
