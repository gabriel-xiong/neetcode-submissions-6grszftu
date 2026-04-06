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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true; 
        
        return dfs(root);
    }

    public boolean dfs(TreeNode root)
    {   if (root == null)
            return true; 
        
        int leftHeight = countNodes(root.left);
        int rightHeight = countNodes(root.right);

        if (leftHeight - rightHeight > 1 || rightHeight - leftHeight > 1)
            return false; 

        if (!dfs(root.left) || !dfs(root.right))
            return false; 

        return true; 
    }

    public int countNodes(TreeNode root)
    {
        if (root == null)
            return 0; 
        
        return 1 + Math.max(countNodes(root.left), countNodes(root.right));
    }
}
