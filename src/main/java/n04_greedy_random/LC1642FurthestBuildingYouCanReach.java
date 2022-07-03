package n04_greedy_random;

import java.util.PriorityQueue;

public class LC1642FurthestBuildingYouCanReach
{
    /*
    Using Min-Heap
    The highest climbs take ladder and others take brick.
     */
    public int furthestBuilding1(int[] heights, int bricks, int ladders)
    {
        PriorityQueue<Integer> ladder = new PriorityQueue<>((a, b) -> Integer.compare(a, b)); // Min-heap
        int climb;

        for (int i = 0; i < heights.length - 1; i++)
        {
            climb = heights[i + 1] - heights[i];

            if (climb <= 0) continue;

            // Ladder for largest climb, for others use brick
            ladder.add(climb);

            if (ladder.size() <= ladders) continue;

            bricks -= ladder.poll();

            if (bricks < 0) return i;
        }

        return heights.length - 1;
    }
    /*
    Using max-heap
     */
    public int furthestBuilding2(int[] heights, int bricks, int ladders)
    {
        PriorityQueue<Integer> brickPq = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // Max Heap
        int climb;

        for (int i = 0; i < heights.length - 1; i++)
        {
            climb = heights[i + 1] - heights[i];

            if (climb <= 0) continue;

            // Add Ladder for highest climb
            brickPq.add(climb);
            bricks -= climb;

            if (bricks >= 0) continue;

            // If number of bricks negative, then reclaim the bricks used fo rhighest climb till now and use ladder.

            bricks += brickPq.poll();
            ladders--;

            if (ladders < 0) return i;
        }
        return heights.length - 1;
    }
}
