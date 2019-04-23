/*82. Remove Duplicates from Sorted List II
  Medium

  Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

  Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3*/
//recursive
class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;

		if (head.next != null && head.val == head.next.val) {
			while (head.next != null && head.val == head.next.val) {
				head = head.next;
			}
			return deleteDuplicates(head.next);
		} else {
			head.next = deleteDuplicates(head.next);
		}
		return head;
	}
}
//iterative
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		//use two pointers, slow - track the node before the dup nodes, 
		// fast - to find the last node of dups.
		ListNode dummy = new ListNode(0), fast = head, slow = dummy;
		slow.next = fast;
		while(fast != null) {
			while (fast.next != null && fast.val == fast.next.val) {
				fast = fast.next;    //while loop to find the last node of the dups.
			}
			if (slow.next != fast) { //duplicates detected.
				slow.next = fast.next; //remove the dups.
				fast = slow.next;     //reposition the fast pointer.
			} else { //no dup, move down both pointer.
				slow = slow.next;
				fast = fast.next;
			}

		}
		return dummy.next;
	} 
}

