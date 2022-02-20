/*

Medium


You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.

For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.

Return the head of the modified linked list.

Input: head = [0,3,1,0,4,5,2,0]
Output: [4,11]
Explanation:
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 3 + 1 = 4.
- The sum of the nodes marked in red: 4 + 5 + 2 = 11.

Input: head = [0,1,0,3,0,2,2,0]
Output: [1,3,4]
Explanation:
The above figure represents the given linked list. The modified list contains
- The sum of the nodes marked in green: 1 = 1.
- The sum of the nodes marked in red: 3 = 3.
- The sum of the nodes marked in yellow: 2 + 2 = 4.

Constraints:

The number of nodes in the list is in the range [3, 2 * 105].
0 <= Node.val <= 1000
There are no two consecutive nodes with Node.val == 0.
The beginning and end of the linked list have Node.val == 0.
 */

package leet_code_contests.weekly.wc281_20220219;

import utils.ListNode;

public class LC6013MergeNodesInBetweenZeros {
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
