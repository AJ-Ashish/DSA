class Solution {
    public class Pair{
        char ch;
        int f;

        Pair(char ch, int f) {
            this.ch = ch;
            this.f = f;
        }
    }
    public String reorganizeString(String s){
        int freq[] = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.f,a.f));

        for(int i=0; i<freq.length; i++) {
            if(freq[i] > 0) {
                maxHeap.offer(new Pair((char)('a'+i), freq[i]));
            }
        }
        StringBuilder ans = new StringBuilder();
        Pair block = maxHeap.poll();
        ans.append(block.ch);
        block.f--;

        while(!maxHeap.isEmpty()) {
            Pair temp = maxHeap.poll();
            ans.append(temp.ch);
            temp.f--;
            if(block.f > 0) {
                maxHeap.offer(block);
            }
            block = temp;
        }
        if(block.f > 0) {
            return "";
        }
        return ans.toString();

    }
}