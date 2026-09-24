class Solution {
    // If total number of elements is N and there are K lists:
    // TC = O(N * logk) SC = O(K)
    class Node {
        int value;
        int listIdx;
        int elementIdx;

        public Node(int value, int listIdx, int elementIdx) {
            this.value = value;
            this.listIdx = listIdx;
            this.elementIdx = elementIdx;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.value,b.value));

        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.size(); i++) {
            int value = nums.get(i).get(0);

            minHeap.offer(new Node(value,i,0));
            max = Math.max(max,value);
        }

        int bestLeft = 0;
        int bestRight = Integer.MAX_VALUE;

        while(true) {
            Node current = minHeap.poll();
            int min = current.value;

            // Check current range
            if((max-min < bestRight - bestLeft)  || 
                (max - min == bestRight - bestLeft && min < bestLeft)) {
                bestRight=max;
                bestLeft=min;
            }
             // Move to next element of the same list
            int nextElement = current.elementIdx + 1;

            // If this list is exhausted, we cannot cover all lists anymore
            if(nextElement == nums.get(current.listIdx).size()) {
                break;
            }
            int nextValue = nums.get(current.listIdx).get(nextElement);
            minHeap.offer(new Node( nextValue,current.listIdx ,nextElement));
            max = Math.max(max,nextValue);
        }

        return new int[]{bestLeft,bestRight};
    }
}