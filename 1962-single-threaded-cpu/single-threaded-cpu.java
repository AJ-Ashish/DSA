class Solution {
    public int[] getOrder(int[][] tasks) {
        List<int[]> list = new ArrayList<>();

        for(int i=0; i<tasks.length; i++) {
            list.add(new int[] {tasks[i][0], tasks[i][1], i});
        }

        Collections.sort(list, (a,b) -> Integer.compare(a[0],b[0]));

        
        int ans[] = new int[list.size()];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1]) {
                return Integer.compare(a[2], b[2]);
            }
            return Integer.compare(a[1],b[1]);
        });

        int pointer = 0;
        long currentTime = 0;
        int idx = 0;

        while(idx < ans.length ) {

            // No available task → jump to next enqueue time
            if(minHeap.isEmpty()) {
                currentTime = Math.max(currentTime, list.get(pointer)[0]);;
            }


            // Add all available tasks
            while(pointer < list.size() && list.get(pointer)[0] <= currentTime) {
                minHeap.offer(list.get(pointer));
                pointer++;
            }
            // Pick task with smallest processing time
            int[] task = minHeap.poll();
            currentTime += task[1];
            ans[idx++] = task[2];
        }
        return ans;
    } 
}