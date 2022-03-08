package n01_data_structures;

import utils01.ListNode;

public class LC2181MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode ret = head;

        while (head != null && head.next != null)
        {
            if (head.val == 0)
                head = head.next;
            else
            if (head.next.val == 0)
            {
                head.next = head.next.next;
                head = head.next;
            }

            else
            {
                head.val += head.next.val;
                head.next = head.next.next;
            }
        }

        return ret.next;

    }
}
