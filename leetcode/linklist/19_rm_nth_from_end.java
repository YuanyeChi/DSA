/*
19. Remove Nth Node From End of List
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//use stack
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode i = head;
        Stack<ListNode> s = new Stack<>();
        int count = 0;
        int n1 = n;
        while(i != null) {
            s.push(i);
            i = i.next;
            count += 1;
        }
        //i = null;
        System.out.println(count);
        while (!s.isEmpty() && n != -1){
                i = s.pop();
                n--;
        }
        if (s.isEmpty() && n1 >= count)
            return head.next;
        //if (s.isEmpty())
        //    return head;
        i.next = i.next.next;
        return res.next;
    }
    
   /* public void stackToList(ListNode now, Stack<ListNode> p) {
        now = p.pop();
        if (!p.isEmpty()) {
            stackToList(now.next, p);
        }
    }*/
}

//faster than 100% 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
