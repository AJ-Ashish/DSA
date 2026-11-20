class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        

        int low = 0;
        int high = arr.length-1;
        int peak = low + high / 2;

        while(low < high ) {
            int mid = low - (high + low)/2;

            if(mid-1 >= 0 && arr[mid] > arr[mid-1] && arr[mid] > arr[mid-1]) {
                return mid;
            }else if(mid -1 > 0 && arr[mid] < arr[mid-1]) {
                peak = mid-1;
                high = mid-1;
            }else {
                peak = arr[low] > arr[peak] ? low : peak ;
                low++;
            }
        }
        return peak;
    }
}