//my solution in iterative way 94ms...
class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		for (int i = 0; i < gas.length; i++) {
			if(test(gas, cost, i)) return i;
		}
		return -1;
	}

	public boolean test(int[] gas, int[] cost, int i) {
		int count = 0;
		int tan = gas[i];
		int k;
		if (i == cost.length - 1)
			k = 0;
		else 
			k = i + 1;
		while (count <= gas.length) {
			if (tan  - cost[i] < 0) return false;
			tan = tan - cost[i] + gas[k];
			if (i == (cost.length - 1))
				i = 0;
			else 
				i++;
			if (k == (gas.length - 1))
				k = 0;
			else 
				k++;
			count++;
		}
		return true;
	}
}

//amazing solution from a Chinese guy
//find the most impossible one and test it
//how to find? find the fuel's maximum subarray
public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] fuel = new int[gas.length];
		int start = 0;
		int sum = 0;
		for(int i = 0; i < gas.length; i++)	{
			fuel[i] = gas[i] - cost[i];
			sum += fuel[i];
			if(sum < 0) {
				sum = 0;
				start = i + 1;
				if(start == gas.length)	{
					return -1;
				}
			}
		}
		int result = start;
		sum = 0;
		for(int i = 0 ; i < gas.length; i++) {
			if(start + i == gas.length)	{
				start = -i;//amazing way to turn to [0]
			}
			sum += fuel[start + i];
			if(sum < 0)	{
				return -1;
			}
		}
		return result;
	}
}

