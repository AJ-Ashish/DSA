// Brute Force Solution 
// TC = O(n2) bcz we repeatedly scans for oponent 
// SC = O(n ) for the active array 
/*
class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();

        boolean[] active = new boolean[n];
        Arrays.fill(active, true);

        int radiant = 0;
        int dire = 0;

        for(char ch : senate.toCharArray()) {
            if(ch == 'R') {
                radiant++;
            }else {
                dire++;
            }
        }
        while(radiant > 0 && dire > 0) {
            for(int i=0; i<n && radiant>0 && dire>0; i++) {
                if(!active[i]) continue;

                // Find the next active opponent, circularly.
                for(int j =(i+1)%n; j!=i; j=(j+1)%n) {
                    if(active[j] && senate.charAt(i) != senate.charAt(j)) {
                        active[j] = false;
                        if(senate.charAt(j) == 'R') radiant--;
                        else dire--;
                        break;
                    } 
                }
            }
        }
        return radiant == 0 ? "Dire" : "Radiant";
    }
}
*/



// Optimal Solution using queue

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();
        // store the original indices
        for(int i=0; i<n; i++) {
            char c = senate.charAt(i);
            if(c == 'R') {
                radiant.offer(i);
            }else {
                dire.offer(i);
            }
        }

        while(!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();

            if(r < d) {
                radiant.offer(r+n);
            }else {
                dire.offer(d+n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}