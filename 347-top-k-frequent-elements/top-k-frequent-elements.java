class Solution {
    class Element implements Comparable<Element> {
        int num;
        int frequency;

        public Element(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Element e2) {
            return Integer.compare(this.frequency, e2.frequency);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();
        for(int num : map.keySet()) {
            pq.offer(new Element(num, map.get(num)));
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int result[] = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) {
            result[idx] = pq.poll().num;
            idx++;
        } 
        return result;  
    }
}