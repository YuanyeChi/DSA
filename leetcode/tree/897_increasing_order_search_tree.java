/*897. Increasing Order Search Tree
Easy

228

266

Favorite

Share
Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  
Note:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.
*/
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
