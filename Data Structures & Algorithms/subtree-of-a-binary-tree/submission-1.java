/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (sameTree(root, subRoot))
            return true; 
        
        if (root == null)
            return false; 
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode p, TreeNode q)
    {
        if (p == null && q != null)
            return false; 
        if (p != null && q == null)
            return false; 
        if (p == null && q == null)
            return true; 

        return p.val == q.val && sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }
}
