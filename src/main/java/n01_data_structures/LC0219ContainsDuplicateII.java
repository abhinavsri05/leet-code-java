package n01_data_structures;

import java.util.HashSet;

public class LC0219ContainsDuplicateII {
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        HashMap<Integer, Integer> list = new HashMap<>(); // Value, Index
//
//        for (int i = 0; i < nums.length; i++)
//        {
//            if (list.containsKey(nums[i]) && Math.abs(list.get(nums[i]) - i) <= k)
//                return true;
//            list.put(nums[i], i);
//        }
//        return false;
//    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> lastK = new HashSet<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (lastK.contains(nums[i])) return true;
            lastK.add(nums[i]);
            if (lastK.size() > k) lastK.remove(nums[i - k]);
        }
        return false;
    }
}
