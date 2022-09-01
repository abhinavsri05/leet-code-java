package n01_data_structures;

import utils01.ListNode;

public class LC0234PalindromeLinkedList
{
    // This is O(n) space
    ListNode front;
    public boolean checkFrontAndBack(ListNode node)
    {
        // This node needs to go through end
        if (node == null) return true;
        boolean ret = checkFrontAndBack(node.next);
        if (!ret) return ret;
        ret = node.val == front.val;
        if (!ret) return ret;
        front = front.next;
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        // The number of digits are huge (upto 10^5)
        front = head;
        return checkFrontAndBack(head);
    }
}
