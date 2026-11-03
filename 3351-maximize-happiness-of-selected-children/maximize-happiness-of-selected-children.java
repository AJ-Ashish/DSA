class Solution {
    // TC = O(nlogn+k) SC=O(1)
    public long maximumHappinessSum(int[] happiness, int k) {
        
        Arrays.sort(happiness);
        long deleted = 0;

        int idx = happiness.length-1;
        long sum = 0;
        for(int i=0; i<k; i++) {
            if(happiness[idx] <= deleted) {
                break;
            }
            sum += happiness[idx] - deleted;
            deleted++;
            idx--;
        }
        return sum;
    }
}