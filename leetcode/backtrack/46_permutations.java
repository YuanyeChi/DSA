/*
46. Permutations
Medium

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        backtracking(res, nums, new ArrayList<>());
        return res;
    }
    
    private void backtracking(List<List<Integer>> res, int[] nums, List<Integer> tempList){
        if (tempList.size() == nums.length){
            res.add(new ArrayList<>(tempList));//pay attention to this, new an arraylist
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtracking(res, nums, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
