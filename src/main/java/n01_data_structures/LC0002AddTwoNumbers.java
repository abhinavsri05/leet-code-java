package n01_data_structures;

import utils01.ListNode;

public class LC0002AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int sum;

        while (l1 != null || l2 != null || carry > 0)  // Last condition is needed since the sum length may be more than individual numbers
        {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            ListNode node = new ListNode(sum >= 10 ? sum - 10 : sum);
            carry = sum >= 10 ? 1 : 0;
            /*
            Can be replaced with-

            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;

            */
            prev.next = node;
            prev = node;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return dummy.next;

    }
}
