/**
75. Sort Colors
Medium

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

*/

//Runtime: 35 ms, faster than 6.36% of Java online submissions for Sort Colors.
//Memory Usage: 35 MB, less than 73.20% of Java online submissions for Sort Colors.
class Solution {
    public void sortColors(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) list1.add(0);
            if (nums[i] == 1) list2.add(1);
            if (nums[i] == 2) list3.add(2);      
        }
        list1.addAll(list2);
        list1.addAll(list3);
        int[] ans = list1.stream().mapToInt(Integer::intValue).toArray();
        System.arraycopy(ans, 0, nums, 0, ans.length);
    }
}
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
//Memory Usage: 37.3 MB, less than 33.14% of Java online submissions for Sort Colors.
class Solution {
    public void sortColors(int nums[]) {
    int num0 = 0, num1 = 0, num2 = 0;
    for(int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) ++num0;
        else if (nums[i] == 1) ++num1;
        else if (nums[i] == 2) ++num2;
    }
    
    for(int i = 0; i < num0; ++i) nums[i] = 0;
    for(int i = 0; i < num1; ++i) nums[num0+i] = 1;
    for(int i = 0; i < num2; ++i) nums[num0+num1+i] = 2;
}
}
