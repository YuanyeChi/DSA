/*Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

easy

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0*/
//O(N)
class Solution {
	public int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
		}
		if (nums[0] > target)
			return 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] < target && nums[i + 1] > target)
				return i + 1;        
		}
		return nums.length;
	}
}
//O(logn) binary search
class Solution {
	public int searchInsert(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (mid == target)
				return mid;
			else if (target < nums[mid])
				high = mid - 1;
			else
				low = mid + 1
		}
		return low;
	}
