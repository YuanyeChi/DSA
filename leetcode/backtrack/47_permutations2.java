/*
47. Permutations II

Medium

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);//it is necessary
        backtrack(res, nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> tempList, boolean[] used) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                /* i > 0 && nums[i] == nums[i - 1] && !used[i - 1] to avoid the dupicate number
                Your input [1,1,2]
                Output [[1,1,2],[1,2,1],[1,1,2],[1,2,1],[2,1,1],[2,1,1]]
                Expected [[1,1,2],[1,2,1],[2,1,1]]
                we can see [1,1,2],[1,2,1]  is dupicated*/
                
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;// to avoid next backtrack use this index
                tempList.add(nums[i]);
                backtrack(res, nums, tempList, used);
                used[i] = false;// now release
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
