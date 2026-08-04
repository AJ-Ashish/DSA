class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int min = nums[0];
        int num = min;
        int i = 1;
        while(i < nums.length) {
           num = num+1; 
            if(num == nums[i]) {
                i++;            
            }else {
                list.add(num);
            }
        }
        return list;

    }
}