package n01_data_structures;

import utils01.ListNode;

public class LC0061RotateList {
    // Attempt 1 (Took close to 1400 ms)
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode pt1 = head;
        ListNode pt2 = head;
        int count = 0;

        // move second pointer k ahead in circular fashion
        while (count < k)
        {
            count++;
            pt2 = pt2.next == null ? head : pt2.next;
        }

        // Find null for pt2
        while (pt2.next != null)
        {
            pt2 = pt2.next;
            pt1 = pt1.next;
        }

        pt2.next = head;
        ListNode output = pt1.next;
        pt1.next = null;

        return output;
    }

    // Attempt 2 (0-1 ms)
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode pt1 = head;
        ListNode pt2 = head;
        int count = 0;

        // move second pointer k ahead in circular fashion
        while (count < k)
        {
            count++;
            if (pt2.next == null)
            {
                k = k % count; // At this state I know the length. No need to keep going around the list again and again.
                count = 0;
            }
            pt2 = pt2.next == null ? head : pt2.next;
        }

        // Find null for pt2
        while (pt2.next != null)
        {
            pt2 = pt2.next;
            pt1 = pt1.next;
        }

        pt2.next = head;
        ListNode output = pt1.next;
        pt1.next = null;

        return output;
    }

    // Attempt 3 (LC Solution: This attempt iterates the list less than 2 times. The last one iterated exactly 2 times).
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode pt1 = head;
        int len = 1;
        int i = 1;

        while (pt1.next != null)
        {
            len++;
            pt1 = pt1.next;
        }
        pt1.next = head; // Not this is a circular list of length = len
        pt1 = head;

        k = len - (k % len);

        while (i < k)
        {
            pt1 = pt1.next;
            i++;
        }

        head = pt1.next;
        pt1.next = null;

        return head;

    }

}
