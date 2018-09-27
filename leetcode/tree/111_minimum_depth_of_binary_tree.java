/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//DFS
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
         
    int leftMin = minDepth(root.left);
    int rightMin = minDepth(root.right);
        
    if (leftMin == 0) {
        return rightMin + 1;
    } else if (rightMin == 0) {
        return leftMin + 1;
    } else {
        return Math.min(leftMin, rightMin) + 1;
    }
    }
}
//BFS
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
