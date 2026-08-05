// Properties of binary tree
// 1. Child should have only one parent 
// 2. Only one root (no parent ) should present
// 3. Conected 


class Solution {
    // TC = O(n) && SC = O(n)
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        // Step 1: Find parent of every node
        HashMap<Integer,Integer> parent = new HashMap<>();
       
        for(int i=0; i<n; i++) {
            
            if(leftChild[i] != -1 ) {
                if(parent.containsKey(leftChild[i])) {
                    return false;
                }
                parent.put(leftChild[i],i);
            }
            if(rightChild[i] != -1 ) {
                if(parent.containsKey(rightChild[i])) {
                    return false;
                }
                parent.put(rightChild[i],i);
            }
        }

        // Step 2: Find the root
        int root = -1;
        for(int i=0; i<n; i++) {
            if(!parent.containsKey(i) ) {
                if(root != -1) { 
                    return false; // More than one root
                }
                root = i;
            } 
        }
        if(root == -1 ) {
            return false;
        }

         // Step 3: BFS to check connectivity and cycle
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n];
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(visited[node] == true) {
                return false;
            }
            visited[node] = true;
            count++;

            if(leftChild[node] != -1) {
                queue.offer(leftChild[node]);
            }
            if(rightChild[node] != -1) {
                queue.offer(rightChild[node]);
            }
        }
        return count == n;
    }
}