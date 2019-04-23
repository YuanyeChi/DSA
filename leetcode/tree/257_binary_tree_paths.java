/*257. Binary Tree Paths
Easy

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]*/

Explanation: All root-to-leaf paths are: 1->2->5, 1->3class Solution {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new LinkedList<>();

		if (root == null) return paths;

		if(root.left == null && root.right == null){
			paths.add(root.val + "");
			return paths;
		}

		for (String path : binaryTreePaths(root.left)) {
			paths.add(root.val + "->" + path);
		}

		for (String path : binaryTreePaths(root.right)) {
			paths.add(root.val + "->" + path);
		}

		return paths;


	}
}
