/*
108. Convert Sorted Array to Binary Search Tree
Easy

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recursive
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        
        TreeNode root = helper(nums, 0, nums.length - 1);
        
        return root;
    }
    
    private TreeNode helper(int[] nums, int low, int high) {
        if (low > high)    return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);
        return node;
    }
}
//iterative
class Solution {
	public class MyNode{
		TreeNode node;
		int start;
		int end;

		public MyNode(int start, int end, TreeNode node){
			this.start = start;
			this.end = end;
			this.node = node;
		}
	}


	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length ==0 ) return null;

		Stack<MyNode> stack = new Stack<MyNode>();
		int mid = 0 + (nums.length -1 - 0)/2;
		TreeNode root = new TreeNode(nums[mid]);
		MyNode MyRoot = new MyNode(0, nums.length -1, root);
		stack.push(MyRoot);
		while(!stack.isEmpty()){
			MyNode curr = stack.pop();
			int oldMid = curr.start + (curr.end - curr.start)/2;
			if(oldMid -1 >= curr.start){
				mid = curr.start + (oldMid-1 - curr.start)/2;
				root = new TreeNode(nums[mid]);
				stack.push(new MyNode(curr.start, oldMid - 1, root));
				curr.node.left = root;
			}

			if(oldMid +1 <= curr.end){
				mid = oldMid +1 + (curr.end - oldMid -1)/2;
				root = new TreeNode(nums[mid]);
				stack.push(new MyNode(oldMid + 1, curr.end, root));
				curr.node.right = root;
			}    
		}

		return MyRoot.node;
	}
}
