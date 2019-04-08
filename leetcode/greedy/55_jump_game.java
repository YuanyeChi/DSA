/*55. Jump Game
Medium

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.*/

//backtracking
/*
Time complexity : O(2^n). There are 2^n (upper bound) ways of jumping from the first position to the last, where nn is the length of array nums. For a complete proof, please refer to Appendix A.

Space complexity : O(n). Recursion requires additional memory for the stack frames. 
*/
class Solution {
	public boolean canJump(int[] nums) {
		return canJump1(nums, 0);
	}
	public boolean canJump1(int[] nums, int i) {
		if (i == nums.length - 1)
			return true;       
		int reachable = Math.min(i + nums[i], nums.length - 1);
		for (int k = i + 1; k <= reachable; k++ ) {
			if(canJump1(nums,k))
				return true;
		}
		return false;
	}
}

//DP
/*Time complexity : O(n^2). For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index. nums[i] can be at most n, where n is the length of array nums.

Space complexity : O(2n) = O(n). First n originates from recursion. Second n comes from the usage of the memo table. */
enum Index {
    GOOD, BAD, UNKNOWN
}

public class Solution {
    Index[] memo;

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }
}

//greedy
//Time complexity : O(n). We are doing a single pass through the nums array, hence n steps, where n is the length of array nums.
//Space complexity : O(1). We are not using any extra memory.
Space complexity : O(1)O(1). We are not using any extra memory.
public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}


