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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1]; 
        int[] count = new int[] {1};
        inOrder(ans, root, count, k); 
        return ans[0]; 
    }

    private void inOrder(int[] ans, TreeNode root, int[] count, int k)
    {   
        if (root == null)
            return;

        inOrder(ans, root.left, count, k);

        if (count[0] == k)
           { ans[0] = root.val; count[0]++; 
             return; }
        count[0]++;
        inOrder(ans, root.right, count, k);

    }
}
