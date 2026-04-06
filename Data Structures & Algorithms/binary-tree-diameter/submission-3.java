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
 * }The diameter of a binary tree is defined as the length of the longest path between any two nodes within the tree. The path does not necessarily have to pass through the root.


 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
       int[] ans = new int[1]; 
       dfs(ans, root);
       return ans[0]; 
    }

    static int dfs(int[] ans, TreeNode root)
    {   if (root == null)
            return 0; 

        int localDiameter = dfs(ans, root.left) + dfs(ans, root.right);
        ans[0] = Math.max(ans[0], localDiameter);
        return 1+ Math.max(dfs(ans, root.right), dfs(ans, root.left)); 
    }

  
}
