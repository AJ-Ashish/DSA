class Solution {
    // Tc = O(n) and SC = O(n)
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }
        int round = 0;
        // for (int frequency : map.values()) {
        //     if (frequency == 1) {
        //         return -1;
        //     }

        //     round += (frequency + 2) / 3;
        // }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();

            if(frequency == 1 ) {
                return -1;
            }
            if(frequency % 3 == 0) {
                round += frequency/3;
            }else {
                round += (frequency/3) + 1;
            }
        }
        return round;
        
    }
}