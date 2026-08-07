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
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            
            int size = queue.size();
            int currMax = Integer.MIN_VALUE;

            for(int i=0; i<size; i++) {
                TreeNode currNode = queue.poll();
                currMax = Math.max(currMax,currNode.val);
                if(currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if(currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(currMax);
        }
        return result;
    }
}