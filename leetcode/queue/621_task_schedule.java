//Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

//However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

//You need to return the least number of intervals the CPU will take to finish all the given tasks.
//Solution1 Priority Queue 
class Solution {
	public int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c: tasks)
			map[c - 'A']++;
		PriorityQueue <Integer> q = new PriorityQueue <> (26, Collections.reverseOrder());
		//PriorityQueue优先队列，保证每次取出的元素是队列中权值最小的	可以用一棵完全二叉树表示
		for (int f: map) {
			if (f > 0)
				q.add(f);
		}
		int time = 0;
		while (!q.isEmpty()) {
			int i = 0;
			List <Integer> temp = new ArrayList <> ();
			while (i <= n) {
				if (!q.isEmpty()) {
					if (q.peek() > 1)
						temp.add(q.poll() - 1);
					else
						q.poll();
				}
				time++;
				if (q.isEmpty() && temp.size() == 0)
					break;
				i++;
			}
			for (int l: temp)
				q.add(l);
		}
		return time;
	}
}

public class Solution {
	public int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c : tasks) 
			map[c - 'A']++;
		Arrays.sort(map);//具体的数字无所谓，我们看的是每个任务的个数
		int time = 0;
		//第一个大循环代表一轮
		while (map[25] > 0) {
			int i = 0;
			//第二个循环是每一轮中取小于n次
			while (i <= n) {
				if (map[25] == 0)
					break;
				if (i < 26 && map[25 - i] > 0)
					map[25 - i]--;
				time++;//无论是否取出time都要+1,
				i++;
			}
			Arrays.sort(map);//n后的元素可能会大于之前
		}
		return time;
	}
}
