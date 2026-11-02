class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr) {
            map.put(num, map.getOrDefault(num,0)+1);    
        }
        int freq[] = new int[map.size()];

        int idx = 0;
        for(int value : map.values()) {
            freq[idx++] = value;
        }
        Arrays.sort(freq);
        int unique = freq.length;

        for(int f : freq) {
            if(k < f) {
                return unique;
            }
            k -= f;
            unique--;
        }
        return unique;
    }
}