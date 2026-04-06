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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true; 

        if (root.left != null && root.left.val >=root.val)
            return false; 

        if (root.right !=null && root.right.val <= root.val)
            return false; 

        return isLesser(root.val, root.left) && isGreater(root.val, root.right) && isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isGreater(int val, TreeNode root)
        {
            if (root == null)
                return true; 
            
            if (root.val <= val)
                return false; 

            return isGreater(val, root.right) && isGreater(val, root.left); 
        }

        private boolean isLesser(int val, TreeNode root)
        {
            if (root == null)
                return true; 

            if (root.val >= val)
                return false; 

            return isLesser(val, root.left) && isLesser(val, root.right); 
        }
}
