/*113. Path Sum II
Medium

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]*/
//recursive
 public class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(root, sum, res, path);
            return res;
        }
        
        public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
            if(root==null) return;
            path.add(root.val);
            
            if(root.left==null && root.right==null ){
                if(root.val==sum)
                    res.add(new ArrayList<Integer>(path));
                return;
            }
            if(root.left!=null) {
                dfs(root.left,sum-root.val,res,path);
                path.remove(path.size()-1);
            }
            if(root.right!=null) {
                dfs(root.right,sum-root.val,res,path);
                path.remove(path.size()-1);
            }
            
        }
    }
//iterative
public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        // sum along the current path
        int pathSum = 0;
        TreeNode prev = null;
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()){
            // go down all the way to the left leaf node
            // add all the left nodes to the stack 
            while (curr != null){
                s.push(curr);
                // record the current path
                path.add(curr.val);
                // record the current sum along the current path
                pathSum += curr.val;
                curr = curr.left;
            }
            // check left leaf node's right subtree 
            // or check if it is not from the right subtree
            // why peek here? 
            // because if it has right subtree, we don't need to push it back
            curr = s.peek();
            if (curr.right != null && curr.right != prev){
                curr = curr.right;
                continue; // back to the outer while loop
            }
            // check leaf 
            if (curr.left == null && curr.right == null && pathSum == sum){
                list.add(new ArrayList<Integer>(path));
                // why do we need new arraylist here?
                // if we are using the same path variable path
                // path will be cleared after the traversal
            }
            // pop out the current value
            s.pop();
            prev = curr;
            // subtract current node's val from path sum 
            pathSum -= curr.val;
            // as this current node is done, remove it from the current path
            path.remove(path.size() - 1);
            // reset current node to null, so check the next item from the stack 
            curr = null;
        }
        return list;
    }
