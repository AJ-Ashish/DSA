/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode> parent = new HashMap<>();
    void buildParentMap(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left != null) {
            parent.put(root.left,root);
        }
        buildParentMap(root.left);
        if(root.right != null) {
            parent.put(root.right,root);
        }
        buildParentMap(root.right);
    }

    void BFS(TreeNode target, int k, List<Integer> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int level = 0;
        
        while(!queue.isEmpty()) {
            if(k == level ) {
                break;
            }
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)  ) {
                    queue.offer(node.right);
                    visited.add(node.right);
                } 
                TreeNode par = parent.get(node);
                if(par != null && !visited.contains(par)) {
                    queue.offer(par);
                    visited.add(par);
                }
            }
            level++;
        }
        while(!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParentMap(root);
        List<Integer> result = new ArrayList<>();
        BFS(target,k, result);
        return result;
    }
}