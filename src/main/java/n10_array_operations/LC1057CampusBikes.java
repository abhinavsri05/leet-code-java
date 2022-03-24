package n10_array_operations;

import java.util.Arrays;

public class LC1057CampusBikes {
    private class WorkerBike
    {
        int worker;
        int bike;
        int distance;

        public WorkerBike(int w, int b, int d)
        {
            worker = w;
            bike = b;
            distance = d;
        }
    }

    private int manhattan(int[] x, int[] y)
    {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    public int[] assignBikes(int[][] workers, int[][] bikes)
    {
        int w = workers.length;
        int b = bikes.length;
        int[] workerAssignment = new int[w];
        Arrays.fill(workerAssignment, -1);
        boolean[] bikesAssignment = new boolean[b];

        WorkerBike[] workerBike = new WorkerBike[w * b];

        int i, j, wk, bk;

        for (i = 0; i < w; i++)
        {
            for (j = 0; j < b; j++)
            {
                workerBike[i*b + j] = new WorkerBike(i, j, manhattan(workers[i], bikes[j]));
            }
        }

        Arrays.sort(workerBike, (one, two) -> {
            if (one.distance != two.distance) return one.distance - two.distance;
            if (one.worker != two.worker) return one.worker - two.worker;
            return one.bike - two.bike;
        });

        for (i = 0; i < w * b; i++)
        {
            wk = workerBike[i].worker;
            bk = workerBike[i].bike;
            if (workerAssignment[wk] == -1 && !bikesAssignment[bk])
            {
                workerAssignment[wk] = bk;
                bikesAssignment[bk] = true;
            }
        }

        return workerAssignment;

    }
}
