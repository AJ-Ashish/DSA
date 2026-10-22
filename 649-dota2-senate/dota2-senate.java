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