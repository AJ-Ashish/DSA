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
    void countNodes(TreeNode root,HashMap<Integer,Integer> map ) {
        if(root == null) {
            return;
        }
        countNodes(root.left,map);
        map.put(root.val,map.getOrDefault(root.val, 0)+1);
        countNodes(root.right,map);
    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        countNodes(root,map);
        int maxCount = 0;
        List<Integer> list = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value > maxCount) {
                // while(list.size() != 0) {
                //     list.remove(list.size()-1);
                // }

                list.clear();
                list.add(key);
                maxCount = value;
            }else if(value == maxCount) {
                list.add(key);
            }
        }
        int arr[] = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}