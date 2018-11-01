class Solution {
	public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
		if (root == null) return 0;
		if (isLeft == true && root.left == null && root.right == null) return root.val;
		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
	}

	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeaves(root, false);
	}
}

public int sumOfLeftLeaves(TreeNode root) {
	if(root == null) return 0;
	int ans = 0;
	Stack<TreeNode> stack = new Stack<TreeNode>();
	stack.push(root);

	while(!stack.empty()) {
		TreeNode node = stack.pop();
		if(node.left != null) {
			if (node.left.left == null && node.left.right == null)
				ans += node.left.val;
			else
				stack.push(node.left);
		}
		if(node.right != null) {
			if (node.right.left != null || node.right.right != null)
				stack.push(node.right);
		}
	}
	return ans;
}
