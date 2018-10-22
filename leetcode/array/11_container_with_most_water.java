//two pointers
//my 411ms solution lol O(n^2)
class Solution {
	public int maxArea(int[] height) {
		int result = 0;
		for (int index = 0; index < height.length; index++) {
			for (int i = index + 1; i < height.length; i++) {
				int area = Math.min(height[index], height[i]) * (i - index);
				result = Math.max(area, result);
			}
		}
		return result;
	}
}
//O(n)
public class Solution {
	public int maxArea(int[] height) {
		int maxarea = 0, l = 0, r = height.length - 1;
		while (l < r) {
			maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		return maxarea;
	}
}

