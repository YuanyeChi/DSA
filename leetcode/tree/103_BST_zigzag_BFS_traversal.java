/*103. Binary Tree Zigzag Level Order Traversal
Medium

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }
    
    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;
        
        if(sol.size() <= level)
        {
            sol.add(new LinkedList<Integer>());
        }
        
        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);
        
        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
}

//two stacks
class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		TreeNode c=root;
		List<List<Integer>> ans =new ArrayList<List<Integer>>();
		if(c==null) return ans;
		Stack<TreeNode> s1=new Stack<TreeNode>();
		Stack<TreeNode> s2=new Stack<TreeNode>();
		s1.push(root);
		while(!s1.isEmpty()||!s2.isEmpty())
		{
			List<Integer> tmp=new ArrayList<Integer>();
			while(!s1.isEmpty())
			{
				c=s1.pop();
				tmp.add(c.val);
				if(c.left!=null) s2.push(c.left);
				if(c.right!=null) s2.push(c.right);
			}
			ans.add(tmp);
			tmp=new ArrayList<Integer>();
			while(!s2.isEmpty())
			{
				c=s2.pop();
				tmp.add(c.val);
				if(c.right!=null)s1.push(c.right);
				if(c.left!=null)s1.push(c.left);
			}
			if(!tmp.isEmpty()) ans.add(tmp);
		}
		return ans;
	}
}
