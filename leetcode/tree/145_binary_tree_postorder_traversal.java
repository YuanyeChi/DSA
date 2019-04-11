/*145. Binary Tree Postorder Traversal
Hard

Share
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]*/
//recursive 
class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		return postorder(root, res);
	}
	List<Integer> postorder (TreeNode root, List<Integer> res) {   

		while (root == null) {
			return res;
		}

		postorder(root.left, res);
		postorder(root.right, res);
		res.add(root.val);
		return res;
	}
}

//iterativea by two stacks
class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> visitor1 = new Stack<>();
		Stack<TreeNode> visitor2 = new Stack<>();
		visitor1.push(root);
		while(!visitor1.isEmpty()) {
			TreeNode visiting = visitor1.pop();
			visitor2.push(visiting);
			if (visiting.left != null) visitor1.push(visiting.left);
			if (visiting.right != null)  visitor1.push(visiting.right);
		}
		while(!visitor2.isEmpty()) {
			res.add(visitor2.pop().val);
		}
		return res;
	}
}   
//collection.reverse(res); 
//
