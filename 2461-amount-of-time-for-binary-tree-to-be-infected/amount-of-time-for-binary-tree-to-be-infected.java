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
// class Solution {

//     void makeGraph(HashMap<Integer,List<Integer>> adj, int parent, TreeNode root ) {
//         if(root == null) {
//             return ;
//         }
//         adj.putIfAbsent(root.val, new ArrayList<>());
//         if(parent != -1) {
//             adj.get(root.val).add(parent);
//         }
//         if(root.left != null) {
//             adj.get(root.val).add(root.left.val);
//         }
//         if(root.right  != null) {
//             adj.get(root.val).add(root.right.val);
//         }
//         makeGraph(adj, root.val, root.left);
//         makeGraph(adj, root.val, root.right);
//     }
//     public int amountOfTime(TreeNode root, int start) {
//         HashMap<Integer,List<Integer>> adj = new HashMap<>();
//         makeGraph(adj, -1, root);

//         Queue<Integer> queue = new LinkedList<>();
//         queue.offer(start);
//         int time = 0;
//         HashSet<Integer> set = new HashSet<>();
//         set.add(start);

//         while(!queue.isEmpty()) {
//             int size = queue.size();

//             for(int i=0; i<size; i++) {
//                 int currNode = queue.poll();
                
//                 List<Integer> list = adj.get(currNode);
//                 for(int num : list) {
//                     if(!set.contains(num)) {
//                         set.add(num);
//                         queue.add(num);
//                     }
//                 }

//             }
//             time++;
//         }

//         return time-1;
//     }
// }



                        // DFS


class Solution {
    int result = Integer.MIN_VALUE;

    int solve(TreeNode root, int start) {
        if(root == null) {
            return 0;
        }

        int lh = solve(root.left,start);
        int rh = solve(root.right,start);

        if(root.val == start) {
            result = Math.max(lh,rh);
            return -1;
        }else if(lh >= 0 && rh >= 0) {
            return Math.max(lh,rh) + 1;
        }else {
            int d = Math.abs(lh) + Math.abs(rh);
            result = Math.max(result,d);
            return Math.min(lh,rh)-1;
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        solve(root,start);
        return result;

    }
}