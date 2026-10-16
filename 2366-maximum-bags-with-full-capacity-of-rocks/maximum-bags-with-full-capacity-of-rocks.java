class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int n = rocks.length;
        int[] need = new int[n];
        for(int i=0; i<n; i++) {
            need[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(need);
        int count = 0;

        for(int i=0; i<n; i++) {
            if(additionalRocks >= need[i]) {
                additionalRocks -= need[i];
                count++;
            }else {
                break;
            }
        } 
        return count;
    }
}