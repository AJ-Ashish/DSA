class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer((long) num);
        }

        int operations = 0;

        while (minHeap.peek() < k) {
            long first = minHeap.poll();
            long second = minHeap.poll();

            long newValue = first * 2 + second;
            minHeap.offer(newValue);

            operations++;
        }

        return operations;
    }
}