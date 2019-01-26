//Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

//You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
//recursive
class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;
		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}
}
//iterative
class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null) {
			return t2;
		}
		Queue<TreeNode[]> q = new LinkedList<>();
		q.offer(new TreeNode[] {t1, t2});
		while (!q.isEmpty()) {
			TreeNode[] cur = q.poll();

			if (cur[1] == null) {
				continue;
			}

			cur[0].val += cur[1].val;

			if (cur[0].left == null) {
				cur[0].left = cur[1].left;
			} 
			else {
				q.offer(new TreeNode[] {cur[0].left, cur[1].left});
			}
			if (cur[0].right == null) {
				cur[0].right = cur[1].right;
			} 
			else {
				q.offer(new TreeNode[] {cur[0].right, cur[1].right});
			}
		}
		return t1;
	}
}
