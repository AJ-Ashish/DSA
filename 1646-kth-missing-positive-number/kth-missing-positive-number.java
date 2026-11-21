class Solution {
    public int findKthPositive(int[] arr, int k) {
        

        int num = 1;
        int count = 0;

        int i=0;
        while(i < arr.length) {
            while(arr[i] != num) {
                count++;
                if(count == k) {
                    return num;
                }
                num++;
            }
            i++;
            num++;
        }
        if(count != k) {
            num += (k-count-1);
        }
        return num;
    }
}