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
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>(); 

        if (root == null)
            return ans; 

        queue.offer(root); 

        List<List<Integer>> bfs = new ArrayList<>(); 

        while (!queue.isEmpty())
        {
            List<Integer> level = new ArrayList<>();
            int size = queue.size(); 
            for (int i = 0; i < size; i++)
                {
                    TreeNode curr = queue.poll();

                    if (curr!=null)
                    {
                        level.add(curr.val);
                        if (curr.left != null)
                            queue.offer(curr.left);
                        if (curr.right != null)
                            queue.offer(curr.right); 
                    }
                }

            bfs.add(level);
        }

        System.out.println(bfs); 

        for (List<Integer> list: bfs)
            ans.add(list.get(list.size() -1));

        return ans; 
    }
}
