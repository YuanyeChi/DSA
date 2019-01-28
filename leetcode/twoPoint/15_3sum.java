//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//The solution set must not contain duplicate triplets.
//based on two sums
class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<> ();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
				while (low < high) {
					if (nums[low] + nums[high] == sum) {
						res.add(Arrays.asList(nums[i], nums[low], nums[high]));
						while (low < high && nums[low] == nums[low + 1]) low++;
						while (low < high && nums[high] == nums[high - 1]) high--;
						low++; high--;
					} else if (nums[low] + nums[high] < sum) low++;
					else high--;
				}
			}
		}
		return res;
	}
}
//the fastest soulution on leetcode, remains for thinking
class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		if (nums.length < 3) {
			return Collections.emptyList();
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int minValue = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		int negSize = 0;
		int posSize = 0;
		int zeroSize = 0;
		for (int v : nums) {
			if (v < minValue) {
				minValue = v;
			}
			if (v > maxValue) {
				maxValue = v;
			}
			if (v > 0) {
				posSize++;
			} else if (v < 0) {
				negSize++;
			} else {
				zeroSize++;
			}
		}
		if (zeroSize >= 3) {
			res.add(Arrays.asList(0, 0, 0));
		}
		if (negSize == 0 || posSize == 0) {
			return res;
		}
		if (minValue * 2 + maxValue > 0) {
			maxValue = -minValue * 2;
		} else if (maxValue * 2 + minValue < 0) {
			minValue = -maxValue * 2;
		}

		int[] map = new int[maxValue - minValue + 1];
		int[] negs = new int[negSize];
		int[] poses = new int[posSize];
		negSize = 0;
		posSize = 0;
		for (int v : nums) {
			if (v >= minValue && v <= maxValue) {
				if (map[v - minValue]++ == 0) {
					if (v > 0) {
						poses[posSize++] = v;
					} else if (v < 0) {
						negs[negSize++] = v;
					}
				}
			}
		}
		Arrays.sort(poses, 0, posSize);
		Arrays.sort(negs, 0, negSize);
		int basej = 0;
		for (int i = negSize - 1; i >= 0; i--) {
			int nv = negs[i];
			int minp = (-nv) >>> 1;
			while (basej < posSize && poses[basej] < minp) {
				basej++;
			}
			for (int j = basej; j < posSize; j++) {
				int pv = poses[j];
				int cv = 0 - nv - pv;
				if (cv >= nv && cv <= pv) {
					if (cv == nv) {
						if (map[nv - minValue] > 1) {
							res.add(Arrays.asList(nv, nv, pv));
						}
					} else if (cv == pv) {
						if (map[pv - minValue] > 1) {
							res.add(Arrays.asList(nv, pv, pv));
						}
					} else {
						if (map[cv - minValue] > 0) {
							res.add(Arrays.asList(nv, cv, pv));
						}
					}
				} else if (cv < nv) {
					break;
				}
			}
		}
		return res;
	}
}
