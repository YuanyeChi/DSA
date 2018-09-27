class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true; //java和c的null不一样
		if (p == null || q == null) return false;
		if (p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		return false;
	}
}
