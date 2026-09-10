class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(map.get(b), map.get(a)));
        for(char ch : map.keySet()) {
            maxHeap.offer(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            for(int i=0; i<map.get(ch); i++) {
                sb.append(ch);
            }
            
        }
        return sb.toString();
    }
}