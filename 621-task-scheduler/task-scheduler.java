// Time Complexity: O(T)
// Space Complexity: O(1)
// T = number of tasks

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];

        for(char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int f : freq) {
            if(f > 0) {
                maxHeap.offer(f);
            }
        }
        int time = 0;
         // 3. Process tasks in cycles of n + 1
         while(!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
             // One cycle = n + 1
             for(int i=0; i<n+1; i++) {
                if(!maxHeap.isEmpty()) {
                    int f = maxHeap.poll();
                    f--;
                    temp.add(f);
                }
             }
            // Put remaining frequencies back into heap
            for(int f : temp) {
                if(f > 0) {
                    maxHeap.offer(f);
                }
            }
            // If tasks are still remaining,
            // entire n+1 cycle is required
            if(!maxHeap.isEmpty()) {
                time += n+1;
            }
             // Last cycle: don't count unnecessary idle time
            else {
                time += temp.size();
            }
         }
        return time;
    }
}