class Solution {
    // ceil = (x+2)/2
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) {
            maxHeap.offer(num);
        }

        long score = 0;
        for(int i=0; i<k; i++) {
            int max = maxHeap.poll();
            score += max;
            max = (max+2)/3;
            maxHeap.offer(max);
        }
        return score;
    }
}