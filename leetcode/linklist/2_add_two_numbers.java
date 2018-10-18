//my solution
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		double num1 = 0, num2 = 0, sum = 0;
		ListNode dummy = new ListNode(0);
		ListNode result = new ListNode(0);
		dummy.next = result;
		ListNode i1 = l1;//要先定义
		ListNode i2 = l2;
		int ans = 0;
		for (int j = 0; i1 != null; i1 = i1.next, j++) 
			num1 += i1.val * Math.pow(10,j);
		for (int j = 0; i2 != null; i2 = i2.next, j++) {
			num2 += i2.val * Math.pow(10,j);  
		}
		sum = num1 + num2;

		while (sum != 0) {
			ans = sum % 10;
			sum /= 10;
			result.val = ans;
			if (sum != 0) {
				result.next = new ListNode(0);
				result = result.next;      
			}
		}
		return dummy.next;
	}
}
//more direct
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode result = dummy;
		ListNode i1 = l1;
		ListNode i2 = l2;
		int num = 0, sum = 0, e = 0;
		while (i1 != null || i2 != null) {
			int x = (i1 != null) ? i1.val : 0;
			int y = (i2 != null) ? i2.val : 0;
			sum = x + y + e;
			if (i1 != null) i1 = i1.next;
			if (i2 != null) i2 = i2.next;
			e = sum / 10;
			result.next = new ListNode(sum % 10);
			result = result.next;
		}
		if (e > 0) {
			result.next = new ListNode(1);
		}
		return dummy.next;
	}
}
