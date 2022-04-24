package n01_data_structures;

import java.util.LinkedList;

public class LC0706DesignHashMap
{
    private class Bucket
    {
        LinkedList<int[]> list;
        Bucket()
        {
            list = new LinkedList();
        }

        void insert(int key, int value)
        {
            for (int[] element: list)
            {
                if (element[0] == key)
                {
                    element[1] = value;
                    return;
                }
            }

            list.add(new int[]{key, value});
        }

        void delete(int key)
        {
            for (int[] element: list)
            {
                if (element[0] == key)
                {
                    list.remove(element);
                    break;
                }
            }
        }

        int get(int key)
        {
            for (int[] element: list)
            {
                if (element[0] == key)
                {
                    return element[1];
                }
            }
            return -1;
        }
    }

    private Bucket[] hashMap;
    private static final int MOD = 1000;

    public LC0706DesignHashMap()
    {
        hashMap = new Bucket[MOD];
        for (int i = 0; i < MOD; i++)
        {
            hashMap[i] = new Bucket();
        }
    }

    public void put(int key, int value)
    {
        hashMap[key % MOD].insert(key, value);
    }

    public int get(int key)
    {
        return hashMap[key % MOD].get(key);
    }

    public void remove(int key)
    {
        hashMap[key % MOD].delete(key);
    }
}
