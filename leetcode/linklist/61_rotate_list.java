/*61. Rotate List
Medium

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL*/

public ListNode rotateRight(ListNode head, int n) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;

    int i;
    for (i = 0; fast.next != null; i++)//Get the total length 
    	fast = fast.next;
    
    for (int j = i - n % i; j > 0;j--) //Get the i-n%i th node
    	slow = slow.next;
    
    fast.next = dummy.next; //Do the rotation
    dummy.next = slow.next;
    slow.next = null;
    
    return dummy.next;
}
//变成一个圈
class Solution {
public ListNode rotateRight(ListNode head, int n) {
   if (head == null)
		return head;
	
	ListNode copyHead = head;
	
	int len = 1;
	while (copyHead.next != null) {
		copyHead = copyHead.next;
		len++;
	}
	
	copyHead.next = head;
	
	for (int i = len - n % len; i > 1; i--) 
		head = head.next;

	copyHead = head.next;
	head.next = null;

	return copyHead;
    }
}
