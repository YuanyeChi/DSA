class Solution {    
	public TreeNode increasingBST(TreeNode root) {
		Queue <Integer> vals = new LinkedList();
		inorder(root, vals);
		TreeNode ans = new TreeNode(0), cur = ans;
		for (int v: vals) {
			cur.right = new TreeNode(v);
			cur = cur.right;
		}
		return ans.right;
	}

	public void inorder(TreeNode node, Queue<Integer> vals) {
		if (node == null) return;
		inorder(node.left, vals);
		vals.offer(node.val);
		inorder(node.right, vals);
	}
}


class Solution {
	TreeNode cur;
	public TreeNode increasingBST(TreeNode root) {
		TreeNode dummy = new TreeNode(0);
		cur = dummy;
		inorder(root);
		return dummy.right;
	}

	public void inorder(TreeNode node) {
		if (node == null) return;
		inorder(node.left);
		node.left = null;
		cur.right = node;
		cur = node;
		inorder(node.right);
	}
}
