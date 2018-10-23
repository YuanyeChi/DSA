//two recurtions, use the depth function to heip
class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		int lefCount = depth(root.left);
		int rigCount = depth(root.right);
		return Math.abs(lefCount - rigCount) <= 1 && isBalanced(root.left) && isBalanced(root.right); 
	}

	public int depth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
}

//o(n) 
class Solution {
	public boolean isBalanced(TreeNode root) {
		return dfsSearch(root) != -1;
	}

	public int dfsSearch(TreeNode root) {
		if (root == null) return 0;
		//to maintiain the false result
		int leftHeight = dfsSearch(root.left);
		int rightHeight = dfsSearch(root.right);
		if (leftHeight == -1) return -1;
		if (rightHeight == -1) return -1;
		//if > 1, the tree is not balanced
		if (Math.abs(leftHeight - rightHeight) > 1) return -1;
		//measure the depth
		return Math.max(leftHeight, rightHeight) + 1;


	}
}
