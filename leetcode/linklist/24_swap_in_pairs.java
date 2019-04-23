/*24. Swap Nodes in Pairs
Medium

Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**amazing recursive sulotion～～
Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
Memory Usage: 35.8 MB, less than 91.13% of Java online submissions for Swap Nodes in Pairs.*/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode third = second.next;
        
        second.next = head;
        head.next = swapPairs(third);
        
        return second;
    }
}
