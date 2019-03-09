//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//Example 1:
//Input: [2,2,1]
//Output: 1
//
//Example 2:
//Input: [4,1,2,1,2]
//Output: 4

//hashmap
class Solution {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], i);
			else 
				map.remove(nums[i]);            
		}
		return map.entrySet().iterator().next().getKey();//use iterator to get elements
	}
}

//XOR
// a ^ a = 0, a ^ 0 = a, 0 ^ a = a
class Solution{
	public int singleNumber(int [] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans ^= nums[i];
		}
		return ans;
	}
}
