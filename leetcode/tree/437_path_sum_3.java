class Solution {
	public int pathSum(TreeNode root, int sum) {
		if (root == null) return 0;
		return pathSumFrom(root, sum, 0) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	public int pathSumFrom(TreeNode node, int sum, int cur) {
		if (node == null) return 0;
		cur += node.val;
		return (cur == sum ? 1 : 0) + pathSumFrom(node.left, sum, cur) + pathSumFrom(node.right, sum, cur);    
	}
}
