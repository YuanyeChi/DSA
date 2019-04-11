/*107. Binary Tree Level Order Traversal II
Easy

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]*/
//BFS
class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		List<List<Integer>> ans = new LinkedList<List<Integer>>();

		if(root == null) 
			return ans;

		q.offer(root);

		while(!q.isEmpty()) {
			int level = q.size();
			List<Integer> sublist = new LinkedList<Integer>();
			for(int i = 0; i < level; i++) {
				if (q.peek().left != null)
					q.offer(q.peek().left);
				if (q.peek().right != null)
					q.offer(q.peek().right);
				sublist.add(q.poll().val);//将本层的数放到子表中
			}
			ans.add(0, sublist);//将子表放到开头，其余元素后移一格
		}
		return ans;
	}
}
//DFS
class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new LinkedList<>();
		levelOrderTraversal(ans, root, 0);
		return ans;
	}

	public void levelOrderTraversal(List<List<Integer>> list, TreeNode root, int level) {
		if (root == null) return;
		if (level >= list.size()) {
			list.add(0, new LinkedList<Integer>());
		}
		levelOrderTraversal(list, root.left, level + 1);
		levelOrderTraversal(list, root.right, level + 1);
		list.get(list.size() - level - 1).add(root.val);
	}
}

