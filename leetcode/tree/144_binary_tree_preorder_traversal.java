public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

//recursion 1 pay attention to addAll
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		return preorder(root);
	}

	List<Integer> preorder (TreeNode root) {
		List<Integer> res = new ArrayList<>();
		while (root == null) {
			return res;
		}

		res.add(root.val);
		res.addAll(preorder(root.left));
		res.addAll(preorder(root.right));//学习了字符串拼接
		return res;
	}
}

//recursion 2 import arraylist into method to avoid nea object creating
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		return preorder(root, res);
	}

	List<Integer> preorder (TreeNode root, List<Integer> res) {
		while (root == null) {
			return res;
		}

		res.add(root.val);
		preorder(root.left, res);
		preorder(root.right, res);
		return res;
	}
}

//iteration queue/stack + while
class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Stack<TreeNode> visit = new Stack<>();
		visit.push(root);
		while (!visit.isEmpty()) {
			TreeNode visiting = visit.pop();
			res.add(visiting.val);
			if (visiting.right != null) visit.push(visiting.right);
			if (visiting.left != null) visit.push(visiting.left);

		}
		return res;
	}
}
//attention for iterative: exchange the left and right for the stack's property of stack
////visiting should be created at first, every pop() brings a true manipulate
