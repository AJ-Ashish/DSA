class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone : stones) {
            pq.add(stone);
        }
        while(pq.size() > 1) {
            int num1 = pq.remove();
            int num2 = pq.remove();
            if(num1 != num2) {
                pq.add(num1-num2);
            }
        }
        return pq.isEmpty() ? 0 : pq.remove();
    }
}