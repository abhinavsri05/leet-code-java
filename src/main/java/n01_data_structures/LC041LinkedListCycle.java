package n01_data_structures;

import utils01.ListNode;

public class LC041LinkedListCycle {
//    public boolean hasCycle(ListNode head) {
//        HashSet<ListNode> seen = new HashSet<>();
//
//        while(head != null)
//        {
//            if (seen.contains(head)) return true;
//            seen.add(head);
//            head = head.next;
//        }
//        return false;
//    }

    // Floyd's Cycle Finding Algorithm
    public boolean hasCycle(ListNode head)
    {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast)
        {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }


}
