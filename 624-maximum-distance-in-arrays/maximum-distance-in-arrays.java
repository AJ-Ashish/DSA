class Solution {
    public int maxDistance(List<List<Integer>> arrays) {

        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int result = 0;

        for(int i=1; i<arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);

            int currMin = arr.get(0);
            int currMax = arr.get(arr.size()-1);
            
            result = Math.max(result,Math.max(Math.abs(min - currMax), Math.abs(max-currMin)));
            
            min = Math.min(min,currMin);
            max = Math.max(max,currMax);
        }
        return result;
    }
}