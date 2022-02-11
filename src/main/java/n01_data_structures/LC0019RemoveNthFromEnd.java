package n01_data_structures;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */



public class LC0019RemoveNthFromEnd
{
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        // Hint: Maintain two pointers and update one with a delay of n steps.

        int i = 1;

        ListNode dummyHead = new ListNode(0);

        dummyHead.next = head;

        ListNode pt = dummyHead, delayedPt = dummyHead;

        while (pt.next != null)
        {
            if (i > n)
            {
                delayedPt = delayedPt.next;
            }

            pt = pt.next;
            i++;
        }

        delayedPt.next = delayedPt.next.next;

        return dummyHead.next;

    }
}
