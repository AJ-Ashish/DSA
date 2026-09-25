class Solution {
    // TC = O(a+b+c) 
    // Sc= O(1) -> auxilary O(a+b+c) for output string if we include it 
    class Pair {
        char ch;
        int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    } 
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x,y) -> Integer.compare(y.freq,x.freq));
        if(a != 0) {
            maxHeap.offer(new Pair('a',a));
        }
        if(b != 0) {
            maxHeap.offer(new Pair('b',b));
        }
        if(c != 0) {
            maxHeap.offer(new Pair('c',c));
        }
        
        StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            Pair first = maxHeap.poll();
            int len = sb.length();

            if(len >= 2 && sb.charAt(len-1) == first.ch && sb.charAt(len-2) == first.ch) {
                if(maxHeap.isEmpty()) break;
                Pair second = maxHeap.poll();
                sb.append(second.ch);
                second.freq--;

                if(second.freq > 0) {
                    maxHeap.offer(new Pair(second.ch, second.freq));
                }
                maxHeap.offer(first);
            }else {
                sb.append(first.ch);
                first.freq--;
                if(first.freq > 0) {
                    maxHeap.offer(new Pair(first.ch, first.freq));
                }
            }
            
        }
        return sb.toString();
    }
}