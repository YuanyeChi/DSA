//backtracking
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
