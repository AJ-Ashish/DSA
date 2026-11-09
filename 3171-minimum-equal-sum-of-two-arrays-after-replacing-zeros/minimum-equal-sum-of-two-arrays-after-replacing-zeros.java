class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long zero1 = 0;

        for(int num : nums1) {
            if(num == 0) {
                zero1++;
                num = 1; //to get minimum sum add smallest possitive ie: 1
            }
            sum1 += num;
        }

        long sum2 = 0;
        long zero2 = 0; 
        for(int num : nums2) {
            if(num == 0) {
                zero2++;
                num = 1; //to get minimum sum add smallest possitive ie: 1
            }
            sum2 += num;
        }

        if(sum1 < sum2 && zero1 == 0) return -1;
        if(sum2 < sum1 && zero2 == 0) return -1;
        return sum1 > sum2 ? sum1 : sum2;
    
    }
}