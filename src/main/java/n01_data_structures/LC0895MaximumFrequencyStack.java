package n01_data_structures;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class LC0895MaximumFrequencyStack {
    // My attempt
    /*
    Does not work for the following input-
    ["FreqStack","push","push","push","push","push","push","push","push","push","push","pop","pop","pop","pop","pop","pop","pop","pop","pop","pop"]
    [[],[1],[0],[0],[1],[5],[4],[1],[5],[1],[6],[],[],[],[],[],[],[],[],[],[]]

    Expected:
        [null,null,null,null,null,null,null,null,null,null,null,1,1,5,1,0,6,4,5,0,1]
    Output:
        [null,null,null,null,null,null,null,null,null,null,null,1,1,5,0,1,6,4,5,0,1]

     */

//    private class FreqStackObject
//    {
//        int order;
//        int frequency;
//        int val;
//
//        FreqStackObject(int o, int f, int v)
//        {
//            order = o;
//            frequency = f;
//            val = v;
//        }
//    }
//
//    private class FreqStackComparator implements Comparator<FreqStackObject>
//    {
//        public int compare(FreqStackObject one, FreqStackObject two)
//        {
//            if (one.frequency > two.frequency) return -1;
//            if (one.frequency < two.frequency) return 1;
//            if (one.order > two.order) return -1;
//            if (one.order < two.order) return 1;
//            return 0;
//        }
//    }
//
//    PriorityQueue<FreqStackObject> freqStack;
//    int order;
//    HashMap<Integer, FreqStackObject> elements;
//
//    public LC0895MaximumFrequencyStack() {
//        freqStack = new PriorityQueue(new FreqStackComparator());
//        order = 0;
//        elements = new HashMap<>();
//    }
//
//    public void push(int val) {
//        if (elements.containsKey(val))
//        {
//            FreqStackObject ele = elements.get(val);
//            freqStack.remove(ele);
//            ele.frequency++;
//            ele.order = order++;
//            freqStack.add(ele);
//        }
//        else
//        {
//            FreqStackObject ele = new FreqStackObject(order++, 1, val);
//            freqStack.add(ele);
//            elements.put(val, ele);
//        }
//
//    }
//
//    public int pop()
//    {
//        FreqStackObject ele = freqStack.poll();
//        if (ele.frequency == 1)
//            elements.remove(ele.val);
//        else
//        {
//            freqStack.remove(ele);
//            ele.frequency--;
//            freqStack.add(ele);
//        }
//
//        return ele.val;
//    }


    // Leet code solution
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> freqStacks;
    int maxFreq;

    public LC0895MaximumFrequencyStack()
    {
        freq = new HashMap<>();
        freqStacks = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {

        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        freqStacks.computeIfAbsent(f, z->new Stack<Integer>()).push(val);

        maxFreq = Math.max(maxFreq, f);
    }

    public int pop()
    {
        int ret = freqStacks.get(maxFreq).pop();

        while (maxFreq >= 0 && (!freqStacks.containsKey(maxFreq) || freqStacks.get(maxFreq).size() == 0)) maxFreq--;

        freq.put(ret, freq.get(ret) - 1);

        return ret;

    }

    // Attempt 3: Using Priority Queue
    /*
       private class FreqStackObject
   {
       int order;
       int frequency;
       int val;

       FreqStackObject(int o, int f, int v)
       {
           order = o;
           frequency = f;
           val = v;
       }
   }

   private class FreqStackComparator implements Comparator<FreqStackObject>
   {
       public int compare(FreqStackObject one, FreqStackObject two)
       {
           if (one.frequency > two.frequency) return -1;
           if (one.frequency < two.frequency) return 1;
           if (one.order > two.order) return -1;
           if (one.order < two.order) return 1;
           return 0;
       }
   }

   PriorityQueue<FreqStackObject> freqStack;
   int order;
   HashMap<Integer, Integer> frequency;

   public FreqStack() {
       freqStack = new PriorityQueue(new FreqStackComparator());
       order = 0;
       frequency = new HashMap<>();
   }

   public void push(int val)
   {
       int freq = frequency.getOrDefault(val, 0) + 1;
       frequency.put(val, freq);

       freqStack.add(new FreqStackObject(++order, freq, val));
   }

   public int pop()
   {
       FreqStackObject ele = freqStack.poll();
       frequency.put(ele.val, frequency.get(ele.val) - 1);
       return ele.val;
   }
     */

    // Attempt 4: Attempt 3 modified to use lambda in place of comparator
    /*
       private class FreqStackObject
   {
       int order;
       int frequency;
       int val;

       FreqStackObject(int o, int f, int v)
       {
           order = o;
           frequency = f;
           val = v;
       }
   }

   PriorityQueue<FreqStackObject> freqStack;
   int order;
   HashMap<Integer, Integer> frequency;

   public FreqStack() {
       freqStack = new PriorityQueue<FreqStackObject>((one, two) ->
                                     {
            if (one.frequency > two.frequency) return -1;
            if (one.frequency < two.frequency) return 1;
            if (one.order > two.order) return -1;
            if (one.order < two.order) return 1;
            return 0;
                                     });
       order = 0;
       frequency = new HashMap<>();
   }

   public void push(int val)
   {
       int freq = frequency.getOrDefault(val, 0) + 1;
       frequency.put(val, freq);

       freqStack.add(new FreqStackObject(++order, freq, val));
   }

   public int pop()
   {
       FreqStackObject ele = freqStack.poll();
       frequency.put(ele.val, frequency.get(ele.val) - 1);
       return ele.val;
   }
     */

    // Attempt 5: Using array
    /*
       PriorityQueue<int[]> freqStack;
   int order;
   HashMap<Integer, Integer> frequency;

   public FreqStack() {
       freqStack = new PriorityQueue<>((one, two) ->
                                     {
            if (one[1] > two[1]) return -1;
            if (one[1] < two[1]) return 1;
            if (one[0] > two[0]) return -1;
            if (one[0] < two[0]) return 1;
            return 0;
                                     });

       // Note compare just needs positive/negative or 0 not necessarily -1, 1.
       // You can just return two[1] - one[1] for first two conditions.

       order = 0;
       frequency = new HashMap<>();
   }

   public void push(int val)
   {
       int freq = frequency.getOrDefault(val, 0) + 1;
       frequency.put(val, freq);

       freqStack.add(new int[]{++order, freq, val});
   }

   public int pop()
   {
       int[] ele = freqStack.poll();
       frequency.put(ele[2], frequency.get(ele[2]) - 1);
       return ele[2];
   }
     */
}
