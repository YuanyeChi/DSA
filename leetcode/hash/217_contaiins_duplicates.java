class Solution {
	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int index = 0; index < nums.length; index++) {
			if (!map.containsKey(nums[index]))
				map.put(nums[index], index);
			else
				return true;
		}
		return false;
	}
}
