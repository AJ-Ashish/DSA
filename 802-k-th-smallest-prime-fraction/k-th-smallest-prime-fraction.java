class Solution {
    // 1/3 < 2/5
    // 1 × 5 < 2 × 3
    // 5 < 6
    // Time  = O(n² log k)
    // Space = O(k)
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Long.compare((long)b[0]*a[1],(long)a[0]*b[1]));
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                maxHeap.offer(new int[] {arr[i],arr[j]});
                if(maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }
}