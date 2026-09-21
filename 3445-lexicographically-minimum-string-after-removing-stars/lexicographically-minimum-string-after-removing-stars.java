// Time:  O(n log n)
// Space: O(n)

class Solution {
    class Pair {
        char ch;
        int idx;
        public Pair(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }
    public String clearStars(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.ch == b.ch) {
                return Integer.compare(b.idx, a.idx);
            }
            return Character.compare(a.ch, b.ch);
        });
        StringBuilder sb = new StringBuilder(s);

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '*') {
                sb.setCharAt(pq.poll().idx,'*');
            }else {
                pq.offer(new Pair(s.charAt(i), i));
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            if(ch != '*')  {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}