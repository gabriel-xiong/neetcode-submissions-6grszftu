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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        dfs(ans, root);
        return ans[0];
    }

    static int dfs(int[] ans, TreeNode root)
    {
        if (root == null)
            return 0; 

        int left = dfs(ans, root.left);
        int right = dfs(ans, root.right);

        ans[0] = Math.max(left + right, ans[0]);

        return 1 + Math.max(left, right); 
    }

  
}
