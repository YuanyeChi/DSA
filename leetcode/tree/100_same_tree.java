//Given two binary trees, write a function to check if they are the same or not.
//Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true; //java和c的null不一样
		if (p == null || q == null) return false;
		if (p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		return false;
	}
}
