/*69. Sqrt(x)
Easy

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.*/
//silly methods
class Solution {
	public int mySqrt(int x) {
		double i = 0;
		for (; i <= x / 2 + 1; i++) {
			if (i * i == x)
				return (int)i;
			else if (i * i > x)
				return (int)(i - 1);
		}
		return (int)i;
	}
}
//recursive way implement binary research
class Solution {
	public int mySqrt(int x) {
		int i = 1, j = x;
		if (x == 0) return 0;
		return searching(i, j, x);
	}

	int searching(int i, int j, int x) {
		int mid = (i + j) / 2;
		if (mid <= x / mid && (mid + 1) > x / (mid + 1))
			return mid;
		else if (mid <= x / mid) 
			return searching(mid, j, x);
		else
			return searching(i, mid, x);
	}
}
//excellent Newton iteration
public class Solution {
	public int mySqrt (int x) {
		if (x <= 1)
			return x;
		double assume = x / 2, err = 0.01;
		while (Math.abs (Math.pow (assume, 2) - x) > err) {
			assume = (assume + x / assume) / 2;
		}
		return (int) Math.floor (assume);
	}
}

