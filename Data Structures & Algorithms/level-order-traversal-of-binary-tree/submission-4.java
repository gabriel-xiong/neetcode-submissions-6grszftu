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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans; 

        queue.offer(root); 

        while (!queue.isEmpty())
        {   List<Integer> level = new ArrayList<>(); 
            int size = queue.size(); 
            for (int i = 0; i < size; i++)
                {
                    TreeNode curr = queue.poll(); 
                    if (queue!= null)
                    {
                        level.add(curr.val);
                        if (curr. left !=null)
                            queue.offer(curr.left);
                        if (curr.right!=null)
                            queue.offer(curr.right); 
                    }

                }

            if (level.size() !=0)
                ans.add(level); 
        }

     return ans;    
    }
}
